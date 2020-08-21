import model.Customer;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CustomerServlet", urlPatterns = "/customer")
public class CustomerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Customer> customerList= new ArrayList<>();
        customerList.add(new Customer(1,"quoc gunner","1984/09/23","19 le do","images\\1.jpg"));
        customerList.add(new Customer(2,"dung luther","1985/09/08","21 ong ich khiem","images\\2.jpg"));
        customerList.add(new Customer(3,"phuong angle","1990/03/03","23 tran cao van","images\\3.jpg"));
        customerList.add(new Customer(4,"tuan shark","1999/07/23","90 phan dinh phung","images\\4.jpg"));
        customerList.add(new Customer(5,"long nhong","2000/09/23","88 hung vuong","images\\5.jpg"));
        customerList.add(new Customer(6,"duc tien","1964/03/01","45 ly thai to","images\\6.jpg"));

        request.setAttribute("customerList",customerList);
        request.getRequestDispatcher("customer.jsp").forward(request,response);
    }
}
