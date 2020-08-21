import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebServlet(name = "CalculatorServlet", urlPatterns = "/calculator")
public class CalculatorServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        double f= Calculator.parseDoubleOrDefault(request.getParameter("fOperand"));
        double s=  Calculator.parseDoubleOrDefault(request.getParameter("sOperand"));
        String o= request.getParameter("operator");
        double res;
        try {
            res = Calculator.calculator(f,s,o);
            request.setAttribute("res",res);
            request.getRequestDispatcher("result.jsp").forward(request,response);
        } catch (DivisionException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
