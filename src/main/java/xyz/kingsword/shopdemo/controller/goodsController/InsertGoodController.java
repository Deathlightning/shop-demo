package xyz.kingsword.shopdemo.controller.goodsController;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

/**
 * @author: wzh date: 2019-05-10 22:11
 * @version: 1.0
 **/
@WebServlet(urlPatterns = "/good/insert", name = "insertGood")
public class InsertGoodController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.getParameterMap().forEach((k, v) -> System.out.println(k + " " + Arrays.toString(v)));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        doPost(req, resp);
    }
}
