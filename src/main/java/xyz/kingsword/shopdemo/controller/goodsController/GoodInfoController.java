package xyz.kingsword.shopdemo.controller.goodsController;

import cn.hutool.json.JSONUtil;
import xyz.kingsword.shopdemo.model.bean.Good;
import xyz.kingsword.shopdemo.model.exception.ParameterException;
import xyz.kingsword.shopdemo.model.service.GoodService;
import xyz.kingsword.shopdemo.model.service.impl.GoodServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebServlet(name = "GoodInfoController", urlPatterns = "/goodInfoController")
public class GoodInfoController extends HttpServlet {
    private GoodService goodService;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String goodId = request.getParameter("goodId");
        Good good = goodService.findOnId(Integer.parseInt(goodId));
        Optional.ofNullable(good).orElseThrow(ParameterException::new);
        String jsonStr = JSONUtil.toJsonStr(good);
        response.setContentType("application/json; charset=utf-8");
        response.getWriter().write(jsonStr);
    }

    @Override
    public void init() {
        this.goodService = new GoodServiceImpl();
    }
}
