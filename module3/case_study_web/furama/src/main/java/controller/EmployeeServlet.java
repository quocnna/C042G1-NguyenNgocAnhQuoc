package controller;

import bussiness.EmployeeManager;
import bussiness.EmployeeManagerImpl;
import common.Paging;
import common.StringUtils;
import model.EmployeeDTO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@WebServlet(name = "EmployeeServlet", urlPatterns = "/admin/employee")
public class EmployeeServlet extends HttpServlet {
    EmployeeManager emmployees= new EmployeeManagerImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getList(request, response);
    }

    private void getList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Paging paging= pagingDefault(request,response);
        String searchVal = request.getParameter("val");
        List<EmployeeDTO> res=!Optional.ofNullable(searchVal).orElse("").isEmpty()?emmployees.searchDTOWithPaging(request.getParameter("by"),searchVal,paging):emmployees.getAllDTOWithPaging(paging);
//        List<NoteType> nts = notetypes.getAll();
//        request.setAttribute("notetypes", nts);
        request.setAttribute("res", res);
        request.setAttribute("paging",paging);
        request.getRequestDispatcher("employee.jsp").forward(request, response);
    }
    private Paging pagingDefault(HttpServletRequest request, HttpServletResponse response) throws SecurityException,IOException{
        int currentPage= StringUtils.parseIntegerOrDefault(request.getParameter("page"));
        return currentPage==0? new Paging(1,"name","asc"): new Paging(currentPage,
                request.getParameter("sortField"),request.getParameter("sortDir"));
    }
}
