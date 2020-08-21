import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "TranslateServlet", urlPatterns = "/translate")
public class TranslateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String,String> map= new HashMap<>();
        map.put("hello","xin chao");
        map.put("world","the gioi");
        map.put("girl","con gai");
        map.put("boy","con trai");
        map.put("table","cai ban");
        map.put("football","bong da");

        String txtSearch= request.getParameter("txtSearch");
        String res= map.get(txtSearch);
        PrintWriter printWriter = response.getWriter();
        printWriter.println("<html>");
        printWriter.println(res!=null?"<h1>"+ res +"</h1>":"Not found");
        printWriter.println("</html>");
    }
}
