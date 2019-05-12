package xyz.kingsword.shopdemo.controller.filter;

import cn.hutool.extra.servlet.ServletUtil;
import xyz.kingsword.shopdemo.model.bean.User;
import xyz.kingsword.shopdemo.model.service.LoginService;

import javax.inject.Inject;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(value = "/", filterName = "loginFilter")
public class AuthFilter implements Filter {
    @Inject
    private LoginService loginService;
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpSession session = httpServletRequest.getSession();
        User user = (User) session.getAttribute("user");

        String url = "/login";
        //先找session再找cookie再没有就去login
        if (user != null) {
            url = user.getType() == 0 ? "/purchase.jsp" : "manager.jsp";
            request.getRequestDispatcher(url).forward(request, response);
        }
        Cookie cookie = ServletUtil.getCookie(httpServletRequest, "username");
        if (cookie != null) {
            String username = cookie.getValue();
            user = loginService.login(username);
            session.setAttribute("user", user);
            url = user.getType() == 0 ? "/purchase.jsp" : "manager.jsp";
            request.getRequestDispatcher(url).forward(request, response);
        }
        request.getRequestDispatcher(url).forward(request, response);
    }
}
