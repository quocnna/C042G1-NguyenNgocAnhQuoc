import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet(name = "Servlet", urlPatterns = "/test")
public class Servlet extends HttpServlet {
    private String jdbcURL = "jdbc:mysql://localhost:3306/demo";
    private String jdbcUsername = "root";
    private String jdbcPassword = "40forever";
    private final String Q1="insert into users (name, email, country) values(?,?,?)";
    private final String Q2= "insert into users (id, name, email, country) values(?,?,?,?)";
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
            connection.setAutoCommit(false);

            PreparedStatement stm1 = connection.prepareCall(Q1);
            stm1.setString(1,"1");
            stm1.setString(2,"2");
            stm1.setString(3,"3");
            stm1.executeUpdate();

            PreparedStatement stm2 = connection.prepareCall(Q2);
            stm2.setString(1,"2");
            stm2.setString(1,"1");
            stm2.setString(2,"2");
            stm2.setString(3,"3");
            stm2.executeUpdate();

            connection.commit();
            connection.setAutoCommit(true);
        }catch (ClassNotFoundException| SQLException e){
            e.printStackTrace();
        }

    }
}
