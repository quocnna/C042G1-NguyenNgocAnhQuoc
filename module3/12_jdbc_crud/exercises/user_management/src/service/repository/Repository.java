package service.repository;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Repository<T> implements IRepository<T> {
    private static final String SELECT_ALL = "select * from users";
    @Override
    public Optional<T> get(int id) {
        return Optional.empty();
    }

    @Override
    public List<T> getAll() {
        List<T> res = new ArrayList<>();
        Connection connection = getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(SELECT_ALL);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String country = rs.getString("country");
                res.add(null);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }

    @Override
    public void save(T t) {

    }

    @Override
    public void update(T t) {

    }

    @Override
    public void delete(int id) {

    }

    private Connection getConnection(){
        Connection connection=null;
        try {
            Context initContext = new InitialContext();
            Context envContext = (Context) initContext.lookup("java:comp/env");
            DataSource ds = (DataSource) envContext.lookup("jdbc/demo");
            connection = ds.getConnection();
        } catch (SQLException | NamingException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
