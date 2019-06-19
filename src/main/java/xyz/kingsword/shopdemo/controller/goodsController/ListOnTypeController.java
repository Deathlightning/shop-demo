package xyz.kingsword.shopdemo.controller.goodsController;

import xyz.kingsword.shopdemo.model.bean.Category;
import xyz.kingsword.shopdemo.model.bean.Good;
import xyz.kingsword.shopdemo.model.service.CategoryService;
import xyz.kingsword.shopdemo.model.service.GoodService;
import xyz.kingsword.shopdemo.model.service.impl.CategoryServiceImpl;
import xyz.kingsword.shopdemo.model.service.impl.GoodServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet(name = "ListOnTypeController", urlPatterns = "/good/listOnTypeController")
public class ListOnTypeController extends HttpServlet {
    private CategoryService categoryService;
    private GoodService goodService;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int category = Integer.parseInt(request.getParameter("classify"));
        Map<Category, List<Category>> classifyMap = categoryService.listCategory();
        request.setAttribute("classifyMap", classifyMap);
        List<Good> goodList = goodService.findOnCategory(category);
        List<String> classifyList = goodService.getClassifyList();
        request.setAttribute("classifyList", classifyList);
        request.setAttribute("goodList", goodList);
        request.getRequestDispatcher("/itemList.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    public void init() {
        this.goodService = new GoodServiceImpl();
        categoryService = new CategoryServiceImpl();
    }
}
