//package xyz.kingsword.shopdemo.controller.filter;
//
//import cn.hutool.extra.servlet.ServletUtil;
//import xyz.kingsword.shopdemo.model.bean.User;
//import xyz.kingsword.shopdemo.model.service.LoginService;
//import xyz.kingsword.shopdemo.model.service.impl.LoginServiceImpl;
//
//import javax.servlet.*;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.http.Cookie;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpSession;
//import java.io.IOException;
//
//@WebFilter(value = "/", filterName = "loginFilter")
//public class AuthFilter implements Filter {
//    @Override
//    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
//        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
//        HttpSession session = httpServletRequest.getSession();
//        User user = (User) session.getAttribute("user");
//        String url = "/index.jsp";
//        if (user == null) {
//            Cookie cookie = ServletUtil.getCookie(httpServletRequest, "username");
//            if (cookie != null) {
//                System.out.println(cookie.getValue());
//                String username = cookie.getValue();
//                LoginService loginService = new LoginServiceImpl();
//                user = loginService.login(username);
//                session.setAttribute("user", user);
//                request.getRequestDispatcher(url).forward(request, response);
//                return;
//            }
//            request.getRequestDispatcher("/login.jsp").forward(request, response);
//            return;
//        }
//        request.getRequestDispatcher(url).forward(request, response);//正常访问
//    }
//}
