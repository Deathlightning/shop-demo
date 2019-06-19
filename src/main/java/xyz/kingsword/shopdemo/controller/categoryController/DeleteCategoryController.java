package xyz.kingsword.shopdemo.controller.categoryController;


import xyz.kingsword.shopdemo.model.exception.ParameterException;
import xyz.kingsword.shopdemo.model.service.CategoryService;
import xyz.kingsword.shopdemo.model.service.ConditionalStrategy;
import xyz.kingsword.shopdemo.model.service.impl.CategoryServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeleteCategoryController", urlPatterns = "/deleteCategory")
public class DeleteCategoryController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idStr = request.getParameter("id");
        ConditionalStrategy.ofCondition(idStr == null).orElseThrow(ParameterException::new);

        int id = Integer.parseInt(idStr);
        CategoryService categoryService = new CategoryServiceImpl();
        categoryService.delete(id);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
