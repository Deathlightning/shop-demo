package xyz.kingsword.shopdemo.controller.userController;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.extra.servlet.ServletUtil;
import xyz.kingsword.shopdemo.model.bean.User;
import xyz.kingsword.shopdemo.model.service.LoginService;

import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet(name = "LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    @Inject
    private LoginService loginService;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Map<String, String> map = ServletUtil.getParamMap(request);
        boolean autoLogin = map.remove("autoLogin") == null;
        User user = BeanUtil.mapToBean(map, User.class, false);
//        loginService.login(user);
        if (autoLogin) {
            ServletUtil.addCookie(response, new Cookie("user", user.getUsername()));
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        doPost(request, response);
    }
}
