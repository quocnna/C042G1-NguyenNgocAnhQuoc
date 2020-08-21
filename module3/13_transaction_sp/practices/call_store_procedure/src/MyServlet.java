import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "MyServlet", urlPatterns = "/testabc")
public class MyServlet extends HttpServlet {
    private String jdbcURL = "jdbc:mysql://localhost:3306/demo";
    private String jdbcUsername = "root";
    private String jdbcPassword = "40forever";
    private Connection connection;

    private final String SQL_CREATE ="create table t2(\n" +
            "id int,\n" +
            "na varchar(50)\n" +
            ");";

    private final String CREATE_SP="delimiter //\n" +
            "create procedure quoc_procedure(a varchar(20),b varchar(20),c varchar(20))\n" +
            "begin\n" +
            "insert into users (name, email, country) values(a,b,c);\n" +
            "end;\n" +
            "// delimiter ;";

    private String query="delimiter //\n" +
            "create procedure quoc_procedure()\n" +
            "begin\n" +
            "insert into users (name, email, country) values('quoc1','quoc1','quoc1');\n" +
            "end;\n" +
            "// delimiter ;";
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        callSP(request,response);
    }

    private void callSP(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
            String runSP = "{ call quoc_procedure(?,?,?) }";
//            Statement statement= connection.createStatement();
//            statement.addBatch(query);
//            statement.executeBatch();

            Statement statement = connection.createStatement();
            statement.execute(CREATE_SP);

            CallableStatement callableStatement= connection.prepareCall(runSP);
            callableStatement.setString(1, "mkyong");
            callableStatement.setString(2, "aaa");
            callableStatement.setString(3, "dddd");
            callableStatement.executeUpdate();
        }
        catch (ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }
        PrintWriter printWriter= response.getWriter();
        printWriter.print("abc");
    }
}
