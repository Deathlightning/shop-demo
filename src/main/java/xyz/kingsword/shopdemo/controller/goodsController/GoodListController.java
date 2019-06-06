package xyz.kingsword.shopdemo.controller.goodsController;

import cn.hutool.db.Page;
import xyz.kingsword.shopdemo.model.bean.Good;
import xyz.kingsword.shopdemo.model.dao.GoodDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author: wzh date: 2019-05-26 21:04
 * @version: 1.0
 **/
@WebServlet(urlPatterns = "/goodList", name = "goodList")
public class GoodListController extends HttpServlet {
    private GoodDao goodDao;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Good> goodList = goodDao.listGood(new Page(1, 20));
        List<String> classifyList = goodDao.getClassify();
        request.setAttribute("goodList", goodList);
        request.setAttribute("classifyList", classifyList);
        request.getRequestDispatcher("/purchase.jsp").forward(request, response);
    }

    @Override
    public void init() {
        goodDao = new GoodDao();
    }
}
