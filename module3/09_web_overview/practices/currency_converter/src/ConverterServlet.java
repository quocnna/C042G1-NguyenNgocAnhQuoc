import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ConverterServlet", urlPatterns = "/converter")
public class ConverterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        double rate = Double.parseDouble(request.getParameter("rate"));
        double amount = Double.parseDouble(request.getParameter("amount"));
        PrintWriter printWriter = response.getWriter();
        printWriter.println("<html>");
        printWriter.printf("<h1>%.2f USD= %.2f VND</h1>",amount,amount*rate);
        printWriter.println("</html>");
    }
}
