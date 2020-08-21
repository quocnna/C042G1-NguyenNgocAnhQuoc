package controller;

import common.StringUtil;
import model.User;
import service.GeneralService;
import service.GeneralServiceImpl;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@WebServlet(name = "GeneralServlet",urlPatterns = "/general")
public class GeneralServlet extends HttpServlet {
    GeneralService generalService= new GeneralServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = Optional.ofNullable(request.getParameter("action")).orElse("");
        switch (action) {
            case "search":
                String searchBy=request.getParameter("by");
                String searchValue=request.getParameter("value");
                if(!searchValue.isEmpty()){
                    List<User> res= generalService.search(searchBy,searchValue);
                    request.setAttribute("list", res);
                    request.setAttribute("columns",StringUtil.tmpCols);
                    request.setAttribute("tblName",StringUtil.tmpTblName);
                    request.getRequestDispatcher("general.jsp").forward(request, response);
                }
                break;
            case "delete":
                int ids = StringUtil.parseIntegerOrDefault(request.getParameter("id"));
                if (ids != 0)
                    generalService.delete(ids);
                break;
            default:
                int id = StringUtil.parseIntegerOrDefault(request.getParameter("id"));
                String name = request.getParameter("name");
                String email = request.getParameter("email");
                String country = request.getParameter("country");
                User product = new User(id, name, email, country);
                if (id != 0)
                    generalService.update(product);
                else
                    generalService.save(product);
        }

        List<User> res= generalService.getAll();
        request.setAttribute("list", res);
        request.setAttribute("columns",StringUtil.tmpCols);
        request.setAttribute("tblName",StringUtil.tmpTblName);
        request.getRequestDispatcher("general.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
