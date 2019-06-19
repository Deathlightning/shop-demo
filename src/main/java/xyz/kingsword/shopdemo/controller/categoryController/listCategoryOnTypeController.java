package xyz.kingsword.shopdemo.controller.categoryController;

import cn.hutool.db.Page;
import xyz.kingsword.shopdemo.model.bean.Category;
import xyz.kingsword.shopdemo.model.exception.ParameterException;
import xyz.kingsword.shopdemo.model.service.CategoryService;
import xyz.kingsword.shopdemo.model.service.impl.CategoryServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@WebServlet(name = "listCategoryOnTypeController", urlPatterns = "/listCategoryOnType")
public class listCategoryOnTypeController extends HttpServlet {
    private CategoryService categoryService;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String parentIdStr = request.getParameter("id");
        String currentPageStr = request.getParameter("id");
        Optional.ofNullable(parentIdStr).orElseThrow(ParameterException::new);
        Optional.ofNullable(currentPageStr).orElseThrow(ParameterException::new);
        int parentId = Integer.parseInt(parentIdStr);
        int currentPage = Integer.parseInt(currentPageStr);
        List<Category> categories = categoryService.listOnParent(parentId, new Page(currentPage, 10));
        request.setAttribute("categories",categories);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    public void init() {
        this.categoryService = new CategoryServiceImpl();
    }
}
