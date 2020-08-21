package service.dao;

import common.StringUtils;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConfigurationDB {
    public static Connection getConnection() {
        Connection connection = null;
        try {
//            Context initContext = new InitialContext();
//            Context envContext = (Context) initContext.lookup("java:comp/env");
//            DataSource ds = (DataSource) envContext.lookup("jdbc/inotes");
//            connection = ds.getConnection();

            Class.forName("com.mysql.jdbc.Driver");
            connection= DriverManager.getConnection(StringUtils.jdbcURL,StringUtils.jdbcUsername,StringUtils.jdbcPassword);
        } catch (ClassNotFoundException | SQLException  e) {
            e.printStackTrace();
        }
        return connection;
    }
}
