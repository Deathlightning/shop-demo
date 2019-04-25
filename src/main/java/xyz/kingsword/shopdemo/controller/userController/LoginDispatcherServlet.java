package xyz.kingsword.shopdemo.controller.userController;

import cn.hutool.extra.servlet.ServletUtil;
import xyz.kingsword.shopdemo.model.bean.User;
import xyz.kingsword.shopdemo.model.service.LoginService;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.Optional;

@WebServlet(name = "loginDispatcher", urlPatterns = "/loginDispatcher")
public class LoginDispatcherServlet extends HttpServlet {
    @Inject
    private LoginService loginService;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        User user;
        Cookie cookie = ServletUtil.getCookie(request, "user");
        if (cookie != null) {
            user = loginService.login(cookie.getValue());
            response.getWriter().write("你是用cookie登录的");
        }
        response.sendRedirect(request.getContextPath() + "/login.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
