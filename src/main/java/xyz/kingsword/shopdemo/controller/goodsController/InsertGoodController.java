package xyz.kingsword.shopdemo.controller.goodsController;

import cn.hutool.json.JSONObject;
import xyz.kingsword.shopdemo.model.bean.Good;
import xyz.kingsword.shopdemo.model.service.GoodService;
import xyz.kingsword.shopdemo.model.service.impl.GoodServiceImpl;
import xyz.kingsword.shopdemo.model.util.ServletJsonUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author: wzh date: 2019-05-10 22:11
 * @version: 1.0
 **/
@WebServlet(urlPatterns = "/good/insert", name = "insertGood")
public class InsertGoodController extends HttpServlet {
    private GoodService goodService;

    @Override//接收json值
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        JSONObject jsonObject = ServletJsonUtil.parseObject(request);
        Good good = jsonObject.toBean(Good.class);
//        good.setName(jsonObject.getStr("商品名称"));
//        good.setClassify(jsonObject.getStr("商品类别"));
//        good.setNumber(jsonObject.getInt("商品库存", 0));
//        good.setPrice(Double.parseDouble(jsonObject.getStr("商品单价")));
        System.out.println(good);
        goodService.insert(good);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    public void init() {
        this.goodService = new GoodServiceImpl();
    }
}
