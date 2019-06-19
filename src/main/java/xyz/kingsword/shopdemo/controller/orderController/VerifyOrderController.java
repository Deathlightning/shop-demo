package xyz.kingsword.shopdemo.controller.orderController;

import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import xyz.kingsword.shopdemo.model.exception.LoginException;
import xyz.kingsword.shopdemo.model.service.ConditionalStrategy;
import xyz.kingsword.shopdemo.model.util.AuthUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet(name = "InsertOrderController", urlPatterns = "/verifyOrderController")
public class VerifyOrderController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ConditionalStrategy.ofCondition(AuthUtil.LoginStatus(request)).orElseThrow(LoginException::new);
        Map<String, String[]> map = request.getParameterMap();
        JSONArray jsonArray = new JSONArray();
        map.forEach((k, v) -> {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put(k, Integer.parseInt(v[0]));
            jsonArray.put(jsonObject);
        });
        String orderInfo = jsonArray.toString();
        request.setAttribute("orderInfo", orderInfo);
        request.getRequestDispatcher("/verifyOrder.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
