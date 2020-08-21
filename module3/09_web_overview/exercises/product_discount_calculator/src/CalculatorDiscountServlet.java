import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CalculatorDiscountServlet", urlPatterns = "/calculator_discount")
public class CalculatorDiscountServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        double price = Double.parseDouble(request.getParameter("price"));
        int discount = Integer.parseInt(request.getParameter("discount"));
        double priceAfterDiscount=price* discount* 0.01;
        double discountAmount = price - priceAfterDiscount;
        PrintWriter printWriter = response.getWriter();
        printWriter.println("<html>");
        printWriter.printf("<h1>Discount Amount is: %.2f and Price After Discount is: %.2f</h1>",discountAmount,priceAfterDiscount);
        printWriter.println("</html>");
    }
}
