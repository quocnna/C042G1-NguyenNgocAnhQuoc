package controller;

import bussiness.NoteTypeManager;
import bussiness.NoteTypeManagerImpl;
import common.Paging;
import common.StringUtils;
import common.Toastr;
import model.NoteType;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@WebServlet(name = "NoteTypeServlet", urlPatterns = "/note_type")
public class NoteTypeServlet extends HttpServlet {
    NoteTypeManager notetypes= new NoteTypeManagerImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Toastr toastr;
        String action = Optional.ofNullable(request.getParameter("action")).orElse("");
        switch (action) {
            case "search":
                Paging paging= pagingDefault(request,response);
                String searchVal=request.getParameter("val");
                if(!searchVal.isEmpty()){
                    List<NoteType> res= notetypes.searchWithPaging(request.getParameter("by"),searchVal, paging);
                    request.setAttribute("res",res);
                    request.setAttribute("paging",paging);
                    request.getRequestDispatcher("note_type.jsp").forward(request,response);
                    return;
                }
                break;
            case "delete":
                notetypes.delete(request.getParameter("id"));
                toastr= new Toastr("success","Delete successful!");
                request.setAttribute("toastr",toastr);
                break;
            default:
                int id = StringUtils.parseIntegerOrDefault(request.getParameter("id"));
                String name = request.getParameter("name");
                String description = request.getParameter("description");
                NoteType n = new NoteType(id, name, description);
                if (id != 0){
                    notetypes.update(n);
                    toastr= new Toastr("success","Update "+name+" successful!");
                }
                else{
                    toastr= new Toastr("success","Create "+name+" successful!");
                    notetypes.save(n);
                }
                request.setAttribute("toastr",toastr);
        }
        getList(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getList(request,response);
    }

    private void getList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Paging paging= pagingDefault(request,response);
        String searchVal = request.getParameter("val");
        List<NoteType> res=!Optional.ofNullable(searchVal).orElse("").isEmpty()?notetypes.searchWithPaging(request.getParameter("by"),searchVal,paging):notetypes.getAllWithPaging(paging);
        request.setAttribute("res",res);
        request.setAttribute("paging",paging);
        request.getRequestDispatcher("note_type.jsp").forward(request,response);
    }
    private Paging pagingDefault(HttpServletRequest request, HttpServletResponse response) throws SecurityException,IOException{
        int currentPage= StringUtils.parseIntegerOrDefault(request.getParameter("page"));
        return currentPage==0? new Paging(1,"name","asc"): new Paging(currentPage,
                request.getParameter("sortField"),request.getParameter("sortDir"));
    }
}
