import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name= request.getParameter("name");
        String password = request.getParameter("password");
        PrintWriter printWriter = response.getWriter();
        printWriter.println("<html>");
        printWriter.println("quoc".equals(name) && "123".equals(password)?"<h1>Hello Quoc Gunner</h1>":"Invalid login");
        printWriter.println("</html>");
    }
}
