import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "Servlet", urlPatterns = "/test")
public class Servlet extends HttpServlet {
    private String jdbcURL = "jdbc:mysql://localhost:3306/demo";
    private String jdbcUsername = "root";
    private String jdbcPassword = "40forever";
    private Connection connection;

    private final String CREATE_SP= "delimiter $$\n" +
            "create procedure quoc_procedure(a varchar(20),b varchar(20),c varchar(20))\n" +
            "begin\n" +
            "insert into users (name, email, country) values(a,b,c);\n" +
            "end;\n" +
            "$$ delimiter ;";

    String createSP = "create procedure quoc_procedure(a varchar(20),b varchar(20),c varchar(20))\n" +
            "begin\n" +
            "insert into users (name, email, country) values(a,b,c);\n" +
            "end;";



    private final String QTEST= "delimiter $$" + System.lineSeparator()+
            "create procedure test_sp() begin end; $$ delimiter ; {escape '\\b'};";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);

            Statement statement = connection.createStatement();
            statement.execute(createSP);

            String call_sp = "{ call quoc_procedure(?,?,?) }";
            CallableStatement callableStatement= connection.prepareCall(call_sp);
            callableStatement.setString(1, "myName");
            callableStatement.setString(2, "myEmail");
            callableStatement.setString(3, "myCountry");
            callableStatement.executeUpdate();
        }
        catch (ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }
        PrintWriter printWriter= response.getWriter();
        printWriter.print("Success");
    }
}
