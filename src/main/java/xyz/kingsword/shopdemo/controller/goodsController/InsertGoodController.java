package xyz.kingsword.shopdemo.controller.goodsController;

import cn.hutool.extra.servlet.ServletUtil;
import xyz.kingsword.shopdemo.model.bean.Good;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author: wzh date: 2019-05-10 22:11
 * @version: 1.0
 **/
public class InsertGoodController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        Good good = ServletUtil.fillBean(req, new Good(), false);
    }
}
