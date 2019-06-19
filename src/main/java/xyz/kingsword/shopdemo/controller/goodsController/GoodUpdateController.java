package xyz.kingsword.shopdemo.controller.goodsController;

import cn.hutool.extra.servlet.ServletUtil;
import xyz.kingsword.shopdemo.model.bean.Good;
import xyz.kingsword.shopdemo.model.service.GoodService;
import xyz.kingsword.shopdemo.model.service.impl.GoodServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author: wzh date: 2019-06-06 10:56
 * @version: 1.0
 **/
@WebServlet(urlPatterns = "/good/updateGood", name = "GoodUpdateController")
public class GoodUpdateController extends HttpServlet {
    private GoodService goodService;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        Good good = ServletUtil.fillBean(req, new Good(), false);
        goodService.update(good);
    }

    @Override
    public void init() {
        this.goodService = new GoodServiceImpl();
    }
}
