package xyz.kingsword.shopdemo.controller.userController;

import cn.hutool.extra.servlet.ServletUtil;
import cn.hutool.http.HttpUtil;
import xyz.kingsword.shopdemo.model.exception.LoginException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LogoutServlet",urlPatterns = "/logout")
public class LogoutServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("user") == null) {
            throw new LoginException("未登录");
        }
        request.getSession().invalidate();
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            cookie.setMaxAge(0);
            cookie.setPath("/");
            response.addCookie(cookie);
        }
        response.sendRedirect("/login.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
