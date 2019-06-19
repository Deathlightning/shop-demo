package xyz.kingsword.shopdemo.controller.categoryController;

import xyz.kingsword.shopdemo.model.bean.Category;
import xyz.kingsword.shopdemo.model.service.CategoryService;
import xyz.kingsword.shopdemo.model.service.impl.CategoryServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet(name = "ListCategoryServlet",urlPatterns = "/listCategoryServlet")
public class ListCategoryController extends HttpServlet {
    private CategoryService categoryService;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<Category, List<Category>> classifyMap = categoryService.listCategory();
        request.setAttribute("classifyMap", classifyMap);
        request.getRequestDispatcher("/nav.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    public void init() {
        this.categoryService = new CategoryServiceImpl();
    }
}
