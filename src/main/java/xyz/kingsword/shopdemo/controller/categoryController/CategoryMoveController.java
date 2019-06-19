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

/**
 * @author: wzh date: 2019-06-18 09:26
 * @version: 1.0
 **/
@WebServlet(name = "CategoryMoveController", urlPatterns = "/categoryMove")
public class CategoryMoveController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idStr = request.getParameter("id");
        String parentIdStr = request.getParameter("parentId");
        ConditionalStrategy.ofCondition(idStr == null || parentIdStr == null).orElseThrow(ParameterException::new);
        int id = Integer.parseInt(idStr);
        int parentId = Integer.parseInt(parentIdStr);
        CategoryService categoryService = new CategoryServiceImpl();
        categoryService.move(id, parentId);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
