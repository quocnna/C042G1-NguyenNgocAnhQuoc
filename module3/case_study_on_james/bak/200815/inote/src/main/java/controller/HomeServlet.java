package controller;

import common.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

@WebServlet(name = "HomeServlet", urlPatterns = "/home")
public class HomeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie[] cookies= request.getCookies();
        if(cookies.length<2) {
            if ("db".equals(request.getParameter("rdconfig"))) {
                StringUtils.jdbcURL =String.format("jdbc:mysql://localhost:3306/%s?allowPublicKeyRetrieval=true&useSSL=false",request.getParameter("dbname"));
                StringUtils.jdbcUsername = request.getParameter("dbusername");
                StringUtils.jdbcPassword = request.getParameter("dbpassword");
                Cookie cDb = new Cookie("cookdb", StringUtils.jdbcURL.trim());
                Cookie cDBUserName = new Cookie("cookuser", StringUtils.jdbcUsername.trim());
                Cookie cDBPassword = new Cookie("cookpass", StringUtils.jdbcPassword.trim());

                cDBUserName.setMaxAge(60 * 60 * 24 * 15);// 15 days
                cDBPassword.setMaxAge(60 * 60 * 24 * 15);
                cDb.setMaxAge(60 * 60 * 24 * 15);
                response.addCookie(cDBUserName);
                response.addCookie(cDBPassword);
                response.addCookie(cDb);
            } else {
                StringUtils.filePath = request.getParameter("filepath");
                Cookie cFilePath = new Cookie("cookFilePath", StringUtils.filePath.trim());
                cFilePath.setMaxAge(60 * 60 * 24 * 60);
                response.addCookie(cFilePath);
            }
        }
        response.sendRedirect("/note");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie[] cookies= request.getCookies();
        if(cookies.length>2){
            for (Cookie cookie : cookies){
                if(cookie.getName().equals("cookuser"))
                    StringUtils.jdbcUsername= cookie.getValue();
                else if(cookie.getName().equals("cookpass"))
                    StringUtils.jdbcPassword= cookie.getValue();
                else if(cookie.getName().equals("cookdb"))
                    StringUtils.jdbcURL= cookie.getValue();
            }
        }
        response.sendRedirect("/note");
    }
}
