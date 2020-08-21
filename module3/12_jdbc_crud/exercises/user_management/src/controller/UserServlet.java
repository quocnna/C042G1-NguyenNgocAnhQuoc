package controller;

import common.StringUtil;
import model.User;
import service.bussiness.UserManager;
import service.bussiness.UserManagerImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@WebServlet(name = "UserServlet", urlPatterns = "/users", loadOnStartup = 1)
public class UserServlet extends HttpServlet {
    UserManager users= new UserManagerImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = Optional.ofNullable(request.getParameter("action")).orElse("");
        switch (action) {
            case "search":
                List<User> res = users.searchByCountry(request.getParameter("search"));
                request.setAttribute("userList", res);
                request.getRequestDispatcher("user.jsp").forward(request, response);
            case "delete":
                int ids = StringUtil.parseIntegerOrDefault(request.getParameter("id"));
                if (ids != 0)
                    users.delete(ids);
                break;
            default:
                int id = StringUtil.parseIntegerOrDefault(request.getParameter("id"));
                String name = request.getParameter("name");
                String email = request.getParameter("email");
                String country = request.getParameter("country");
                User product = new User(id, name, email, country);
                if (id != 0)
                    users.update(product);
                else
                    users.save(product);
        }
        getList(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getList(request, response);
    }

    private void getList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<User> userList = users.getAll();
            request.setAttribute("userList", userList);
            request.getRequestDispatcher("user.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
