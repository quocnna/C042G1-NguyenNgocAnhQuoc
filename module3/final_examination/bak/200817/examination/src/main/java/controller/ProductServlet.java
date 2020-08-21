package controller;

import bussiness.CategoryManager;
import bussiness.CategoryManagerImpl;
import bussiness.ProductManager;
import bussiness.ProductManagerImpl;
import common.Paging;
import common.StringUtils;
import common.Toastr;
import model.Category;
import model.Product;
import model.ProductDTO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@WebServlet(name = "ProductServlet", urlPatterns = "/product")
public class ProductServlet extends HttpServlet {
    ProductManager products= new ProductManagerImpl();
    CategoryManager categorys= new CategoryManagerImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Toastr toastr;
        String action = Optional.ofNullable(request.getParameter("action")).orElse("");
        switch (action) {
            case "search":
                Paging paging= pagingDefault(request,response);
                String searchVal = request.getParameter("val");
                if (!searchVal.isEmpty()) {
                    List<ProductDTO> res = products.searchDTOWithPaging(request.getParameter("by"), searchVal,paging);
                    List<Category> cate = categorys.getAll();
                    request.setAttribute("cate", cate);
                    request.setAttribute("res", res);
                    request.setAttribute("paging",paging);
                    request.getRequestDispatcher("product.jsp").forward(request, response);
                    return;
                }
                break;
            case "delete":
                if(products.delete(request.getParameter("id"))>0){
                    toastr= new Toastr("success","Delete successful!");
                    request.setAttribute("toastr",toastr);
                }
                break;
            default:
                int id = StringUtils.parseIntegerOrDefault(request.getParameter("id"));
                String name = request.getParameter("name");
                double price = Double.parseDouble(request.getParameter("price"));
                int quantity = StringUtils.parseIntegerOrDefault(request.getParameter("quantity"));
                String color = request.getParameter("color");
                int nti = StringUtils.parseIntegerOrDefault(request.getParameter("category"));
                Product n = new Product(id, name, price, quantity, color, nti);
                if (id != 0) {
                    if(products.update(n)>0);
                    toastr= new Toastr("success","Update "+name+" successful!");
                }
                else{
                    if(products.save(n)>0);
                    toastr= new Toastr("success","Create "+name+" successful!");
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
        List<ProductDTO> res=!Optional.ofNullable(searchVal).orElse("").isEmpty()?products.searchDTOWithPaging(request.getParameter("by"),searchVal,paging):products.getAllDTOWithPaging(paging);
        List<Category> cate = categorys.getAll();
        request.setAttribute("cate", cate);
        request.setAttribute("res", res);
        request.setAttribute("paging",paging);
        request.getRequestDispatcher("product.jsp").forward(request, response);
    }
    private Paging pagingDefault(HttpServletRequest request, HttpServletResponse response) throws SecurityException,IOException{
        int currentPage= StringUtils.parseIntegerOrDefault(request.getParameter("page"));
        return currentPage==0? new Paging(1,"name","asc"): new Paging(currentPage,
                request.getParameter("sortField"),request.getParameter("sortDir"));
    }
}
