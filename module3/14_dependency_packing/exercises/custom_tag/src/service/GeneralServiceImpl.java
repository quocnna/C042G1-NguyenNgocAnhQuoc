package service;

import common.StringUtil;
import model.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class GeneralServiceImpl implements GeneralService<User> {
    private Configuration configuration = new Configuration();

    @Override
    public List<User> getAll() {
        List<User> res = new ArrayList<>();
        try {
            Statement stCreateTable = configuration.getConnection().createStatement();
            stCreateTable.execute(StringUtil.create_tbl_query);

            PreparedStatement pst = configuration.getConnection().prepareStatement(StringUtil.select_query);
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
            PreparedStatement preparedStatement = this.configuration.getConnection().prepareStatement(StringUtil.insert_query);
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
            PreparedStatement pst = this.configuration.getConnection().prepareStatement(StringUtil.update_query);
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
            String tmp= StringUtil.delete_query;
            PreparedStatement pst = this.configuration.getConnection().prepareStatement(StringUtil.delete_query);
            pst.setInt(1, id);
            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<User> search(String by, String value) {
        List<User> res = new ArrayList<>();
        try {
            String query= StringUtil.search_by_query.replace("?by",by);
            Statement st= this.configuration.getConnection().createStatement();
            ResultSet rs= st.executeQuery(query.replace("?value",value));

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
