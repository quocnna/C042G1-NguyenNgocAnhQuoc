package service.dao;

import model.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserDAOImpl implements UserDAO {
    private Configuration configuration = new Configuration();
    private static final String INSERT_USERS_SQL = "insert into users (name, email, country) values (?, ?, ?)";
    private static final String SELECT_USER_BY_ID = "select id,name,email,country from users where id =?";
    private static final String SELECT_ALL_USERS = "select id, name, email, country from users order by name";
    private static final String DELETE_USERS_SQL = "delete from users where id = ?";
    private static final String UPDATE_USERS_SQL = "update users set name = ?,email= ?, country =? where id = ?";
    private static final String SEARCH_BYNAME_COUNTRY = "select id, name, email, country from users where country regexp binary '?'";

    @Override
    public Optional<User> get(int id) {
        User res = null;
        try {
            PreparedStatement pst = this.configuration.getConnection().prepareStatement(SELECT_USER_BY_ID);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                String email = rs.getString("email");
                String country = rs.getString("country");
                res = new User(id, name, email, country);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.ofNullable(res);
    }

    @Override
    public List<User> getAll() {
        List<User> res = new ArrayList<>();
        try {
            PreparedStatement pst = configuration.getConnection().prepareStatement(SELECT_ALL_USERS);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String country = rs.getString("country");
                res.add(new User(id, name, email, country));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return res;
    }

    @Override
    public void save(User user) {
        try {
            PreparedStatement preparedStatement = this.configuration.getConnection().prepareStatement(INSERT_USERS_SQL);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getCountry());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(User user) {
        try {
            PreparedStatement pst = this.configuration.getConnection().prepareStatement(UPDATE_USERS_SQL);
            pst.setString(1, user.getName());
            pst.setString(2, user.getEmail());
            pst.setString(3, user.getCountry());
            pst.setInt(4, user.getId());
            pst.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        try {
            PreparedStatement pst = this.configuration.getConnection().prepareStatement(DELETE_USERS_SQL);
            pst.setInt(1, id);
            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<User> search(String country) {
        List<User> res = new ArrayList<>();
        try {
            Statement st= this.configuration.getConnection().createStatement();
            ResultSet rs= st.executeQuery(SEARCH_BYNAME_COUNTRY.replace("?",country));
//            PreparedStatement pst = this.configuration.getConnection().prepareStatement(SEARCH_BYNAME_USER);
//           pst.setString(1, name);
//            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                int rid = rs.getInt(1);
                String rname = rs.getString(2);
                String remail = rs.getString(3);
                String rcountry = rs.getString(4);
                res.add(new User(rid, rname, remail, rcountry));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }
}
