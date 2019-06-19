package xyz.kingsword.shopdemo.controller.goodsController;

import cn.hutool.db.Page;
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

@WebServlet(urlPatterns = "/goodList", name = "goodList")
public class GoodListController extends HttpServlet {
    private GoodService goodService;
    private CategoryService categoryService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<Category, List<Category>> classifyMap = categoryService.listCategory();
        request.setAttribute("classifyMap", classifyMap);
        List<Good> goodList = goodService.list(new Page(1, 20));
        request.setAttribute("goodList", goodList);
        request.getRequestDispatcher("/itemList.jsp").forward(request, response);
    }

    @Override
    public void init() {
        goodService = new GoodServiceImpl();
        categoryService = new CategoryServiceImpl();
    }
}
