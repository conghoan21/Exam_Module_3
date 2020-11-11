package control;

import service.CategoryService;
import service.ICategoryService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CategoryServlet",urlPatterns = "/category")
public class CategoryServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        RequestDispatcher requestDispatcher;
        ICategoryService categoryDAO = new CategoryService();
        request.setAttribute("list",categoryDAO.getAllCategory());
        if(action==null){
            action="";
        }
        switch (action){
            case "editProduct":
                requestDispatcher = request.getRequestDispatcher("view/EditProductForm.jsp");
                break;
            default:
                requestDispatcher = request.getRequestDispatcher("view/CreateProductForm.jsp");
                break;
        }
        requestDispatcher.forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
