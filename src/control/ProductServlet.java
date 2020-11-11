package control;

import service.IProductService;
import service.ProductService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ProductServlet",urlPatterns = "/product")
public class ProductServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action==null){
            action="";
        }
        switch (action){
            case "createNewProduct":
                createNewProduct(request,response);
                break;
            case "editProduct":
                editProduct(request,response);
        }
    }

    private void editProduct(HttpServletRequest request, HttpServletResponse response) {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action==null){
            action="";
        }

        switch (action){
            case "createProduct":
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("/category");
                requestDispatcher.forward(request,response);
                break;
            case "editProduct":
                getEditProduct(request,response);
            default:
                displayAllProduct(request,response);
                break;
        }
    }

    private void getEditProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        IProductService productService = new ProductService();
        int productID = Integer.parseInt(request.getParameter("productID"));
        request.setAttribute("product",productService.getProductByID(productID));
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/category");
        requestDispatcher.forward(request,response);
    }

    private void createNewProduct(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        IProductService productService = new ProductService();
        String productName = request.getParameter("productName");
        int price = Integer.parseInt(request.getParameter("price"));
        int amount = Integer.parseInt(request.getParameter("amount"));
        String color = request.getParameter("color");
        String description = request.getParameter("description");
        int categoryID = Integer.parseInt(request.getParameter("categoryID"));
        productService.addNewProduct(productName,price,color,description,categoryID,amount);
        response.sendRedirect("/product");
    }

    private void displayAllProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        IProductService productService = new ProductService();
        request.setAttribute("list",productService.getAllProduct());
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("list.jsp");
        requestDispatcher.forward(request,response);
    }
}
