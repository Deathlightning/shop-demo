package xyz.kingsword.shopdemo.controller.goodsController;

import xyz.kingsword.shopdemo.model.bean.User;
import xyz.kingsword.shopdemo.model.dao.ShoppingCartDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.*;


@WebServlet(name = "InsertShoppingCartController", urlPatterns = "/insertShoppingCartController")
public class InsertShoppingCartController extends HttpServlet {
    private ShoppingCartDao shoppingCartDao;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @SuppressWarnings("unchecked")
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String goodId = request.getParameter("goodId");
        int goodIdInt = Integer.parseInt(goodId);
        HttpSession session = request.getSession();
        Set<Integer> shoppingCartSet = (Set<Integer>) session.getAttribute("shoppingCartList");
        shoppingCartSet = Optional.ofNullable(shoppingCartSet).orElse(new TreeSet<>());
        shoppingCartSet.add(goodIdInt);
        session.setAttribute("shoppingCartList", shoppingCartSet);
        User user = (User) request.getAttribute("user");
        if (user != null) {
            shoppingCartDao.insert(goodIdInt, user.getId());
        }
    }

    public void init() {
        this.shoppingCartDao = new ShoppingCartDao();
    }
}
