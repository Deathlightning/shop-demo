package xyz.kingsword.shopdemo.controller.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "CharSetEncodingFilter")
public class CharSetEncodingFilter implements Filter {

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        // 处理跨域
        httpServletResponse.setHeader("Access-Control-Allow-Origin", "*");
        httpServletResponse.setHeader("Access-Control-Expose-Headers", "*");
        httpServletResponse.setHeader("Access-Control-Allow-Headers", "*");
        httpServletResponse.setHeader("Access-Control-Allow-Methods", "PUT,POST,GET,DELETE,OPTIONS");
        httpServletResponse.setHeader("X-Powered-By", "Tomcat");
        httpServletResponse.setHeader("Content-Type", "text/html;charset=UTF-8");
        httpServletResponse.setHeader("maxAge", "10000");

        request.setAttribute("Access-Control-Request-Headers", "*");
        chain.doFilter(request, response);
    }

}
