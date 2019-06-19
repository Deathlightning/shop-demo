package xyz.kingsword.shopdemo.controller.categoryController;

import xyz.kingsword.shopdemo.model.bean.Category;
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

@WebServlet(name = "InsertCategoryController",urlPatterns = "/insertCategory")
public class InsertCategoryController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String parentIdStr = request.getParameter("parentId");
        ConditionalStrategy.ofCondition(name == null || parentIdStr == null).orElseThrow(ParameterException::new);
        int parentId = Integer.parseInt(parentIdStr);
        CategoryService categoryService = new CategoryServiceImpl();
        categoryService.insert(new Category(name, parentId));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
