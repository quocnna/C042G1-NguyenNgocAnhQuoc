package controller;

import bussiness.ProductService;
import bussiness.ProductServiceImpl;
import common.StringUtil;
import model.Product;
import dao.ProductDAO;
import dao.ProductDAOImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@WebServlet(name = "ProductServlet", urlPatterns = "/products", loadOnStartup =1 )
public class ProductServlet extends HttpServlet {
    private static ProductService<Product> products = new ProductServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = Optional.ofNullable(request.getParameter("action")).orElse("");
        switch (action) {
            case "search":
                List<Product> listProduct = products.search(request.getParameter("search"));
                request.setAttribute("listProduct", listProduct);
                request.getRequestDispatcher("product/list.jsp").forward(request, response);
            case "delete":
                int ids = StringUtil.parseIntegerOrDefault(request.getParameter("id"));
                if (ids != 0)
                    products.removeById(ids);
                break;
            default:
                int id = StringUtil.parseIntegerOrDefault(request.getParameter("id"));
                String name = request.getParameter("name");
                String category = request.getParameter("category");
                String supplier = request.getParameter("supplier");
                String madein = request.getParameter("madein");
                double price = StringUtil.parseDoubleOrDefault(request.getParameter("price"));
                boolean discontinue = request.getParameter("discontinue") != null;
                Product product = new Product(id, name, madein, price, discontinue, supplier, category);
                if (id != 0)
                    products.update(product);
                else
                    products.save(product);
        }
        getList(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getList(request, response);
    }

    private void getList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> listProduct = products.getAll();
        request.setAttribute("listProduct", listProduct);
        request.getRequestDispatcher("product/list.jsp").forward(request, response);
    }
}
