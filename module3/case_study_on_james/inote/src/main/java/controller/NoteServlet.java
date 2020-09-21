package controller;

import common.BaseCRUD;
import common.Paging;
import common.StringUtils;
import common.Toastr;
import model.Note;
import model.NoteDTO;
import model.NoteType;
import service.bussiness.NoteManager;
import service.bussiness.NoteManagerImpl;
import service.bussiness.NoteTypeManager;
import service.bussiness.NoteTypeManagerImpl;
import service.dao.NoteDAO;
import service.dao.NoteDAOImpl;
import service.file.NoteFileImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@WebServlet(name = "NoteServlet", urlPatterns = "/note")
public class NoteServlet extends HttpServlet {

    NoteManager noteDB= new NoteManagerImpl(new NoteDAOImpl());
    NoteManager noteFile= new NoteManagerImpl(new NoteFileImpl());





    NoteTypeManager notetypes = new NoteTypeManagerImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Toastr toastr;
        String action = Optional.ofNullable(request.getParameter("action")).orElse("");
        switch (action) {
            case "search":
                Paging paging= pagingDefault(request,response);
                String searchVal = request.getParameter("val");
                if (!searchVal.isEmpty()) {
                    List<NoteDTO> res = notes.searchDTOWithPaging(request.getParameter("by"), searchVal,paging);
                    List<NoteType> nts = notetypes.getAll();
                    request.setAttribute("notetypes", nts);
                    request.setAttribute("notes", res);
                    request.setAttribute("paging",paging);
                    request.getRequestDispatcher("note.jsp").forward(request, response);
                    return;
                }
                break;
            case "delete":
                notes.delete(request.getParameter("id"));
                toastr= new Toastr("success","Delete successful!");
                request.setAttribute("toastr",toastr);
                break;
            default:
                int id = StringUtils.parseIntegerOrDefault(request.getParameter("id"));
                String title = request.getParameter("title");
                String content = request.getParameter("content");
                int nti = StringUtils.parseIntegerOrDefault(request.getParameter("notetype"));
                Note n = new Note(id, title, content, nti);
                if (id != 0) {
                    notes.update(n);
                    toastr= new Toastr("success","Update "+title+" successful!");
                }
                else{
                    notes.save(n);
                    toastr= new Toastr("success","Create "+title+" successful!");
                }
                request.setAttribute("toastr",toastr);
        }
        getList(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getList(request, response);
    }

    private void getList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Paging paging= pagingDefault(request,response);
        String searchVal = request.getParameter("val");
        List<NoteDTO> res=!Optional.ofNullable(searchVal).orElse("").isEmpty()?notes.searchDTOWithPaging(request.getParameter("by"),searchVal,paging):notes.getAllDTOWithPaging(paging);
        List<NoteType> nts = notetypes.getAll();
        request.setAttribute("notetypes", nts);
        request.setAttribute("notes", res);
        request.setAttribute("paging",paging);
        request.getRequestDispatcher("note.jsp").forward(request, response);
    }
    private Paging pagingDefault(HttpServletRequest request, HttpServletResponse response) throws SecurityException,IOException{
        int currentPage= StringUtils.parseIntegerOrDefault(request.getParameter("page"));
        return currentPage==0? new Paging(1,"title","asc"): new Paging(currentPage,
                request.getParameter("sortField"),request.getParameter("sortDir"));
    }
}
