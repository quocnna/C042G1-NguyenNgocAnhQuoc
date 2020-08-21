package controller;

import common.*;
import model.Product;
import service.bussiness.ProductManager;
import service.bussiness.ProductManagerImpl;
import service.mysql_dao.ProductMySQLDAOImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

@WebServlet(name = "ProductServlet", urlPatterns = "/product")
public class ProductServlet extends HttpServlet {

    BaseCRUD<Product> mysql= new ProductMySQLDAOImpl();
    ProductManager productManager= new ProductManagerImpl(mysql);
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        UsingAnotation anotation= new UsingAnotation();
//        anotation.aMethod();



        Class object = CustomAnnotatedClass.class;
// Retrieve all annotations from the class
        Annotation[] annotations = object.getAnnotations();
        for( Annotation annotation : annotations ) {
            System.out.println(annotation);
        }
// Checks if an annotation is present
        if( object.isAnnotationPresent( CustomAnnotation.class ) ) {
// Gets the desired annotation
            Annotation annotation = object.getAnnotation(CustomAnnotation.class) ;
            System.out.println(annotation);
        }
// fetch the attributes of the annotation
        for(Annotation annotation : annotations) {
            System.out.println("name: " + annotation);
//            System.out.println("Date of Birth: "+ annotation.);
        }
// the same for all methods of the class
        for( Method method : object.getDeclaredMethods() ) {
            if( method.isAnnotationPresent( CustomAnnotation.class ) ) {
                Annotation annotation = method.getAnnotation(CustomAnnotation.class );
                System.out.println( annotation );
            }
        }
    }
}
