package xyz.kingsword.shopdemo.controller.goodsController;

import xyz.kingsword.shopdemo.model.bean.Good;
import xyz.kingsword.shopdemo.model.service.GoodService;
import xyz.kingsword.shopdemo.model.service.impl.GoodServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;

@WebServlet(name = "ShoppingCartController", urlPatterns = "/shoppingCartController")
public class ShoppingCartController extends HttpServlet {
    private GoodService goodService;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    @SuppressWarnings("unchecked")
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Set<Integer> shoppingCartList = (Set<Integer>) request.getSession().getAttribute("shoppingCartList");
        shoppingCartList = Optional.ofNullable(shoppingCartList).orElse(new TreeSet<>());
        List<Good> goodList = goodService.list(shoppingCartList);
        double sumPrice = goodList.stream().mapToDouble(Good::getPrice).sum();
        List<String> classifyList = goodService.getClassifyList();
        request.setAttribute("goodsList", goodList);
        request.setAttribute("sumPrice", sumPrice);
        request.setAttribute("classifyList", classifyList);
        request.getRequestDispatcher("/shoppingCart.jsp").forward(request, response);
    }

    @Override
    public void init() {
        this.goodService = new GoodServiceImpl();
    }
}
