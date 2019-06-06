package xyz.kingsword.shopdemo.controller.goodsController;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "DeleteShoppingCartController", urlPatterns = "/deleteShoppingCartController")
public class DeleteShoppingCartController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @SuppressWarnings("unchecked")
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer goodId = Integer.parseInt(request.getParameter("goodId"));
        HttpSession session = request.getSession();
        List<Integer> ids = (List<Integer>) session.getAttribute("shoppingCartList");
        if (ids != null) {
            ids.remove(goodId);
            session.setAttribute("shoppingCartList", ids);
        }
        response.getWriter().write("success");
    }
}
