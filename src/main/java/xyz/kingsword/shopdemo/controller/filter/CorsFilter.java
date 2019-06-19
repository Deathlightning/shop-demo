package xyz.kingsword.shopdemo.controller.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "CharSetEncodingFilter", urlPatterns = "/*")
public class CorsFilter implements Filter {

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String uri = httpServletRequest.getRequestURI();
        if (uri.contains(".css") || uri.contains(".js") || uri.contains(".html")) {
            chain.doFilter(request, response);
            return;
        }
        // 处理跨域
        httpServletResponse.setHeader("Access-Control-Allow-Origin", "*");
        httpServletResponse.setHeader("Access-Control-Expose-Headers", "*");
        httpServletResponse.setHeader("Access-Control-Allow-Headers", "*");
        httpServletResponse.setHeader("Access-Control-Allow-Methods", "PUT,POST,GET,DELETE,OPTIONS");
        httpServletResponse.setHeader("X-Powered-By", "Tomcat");
        httpServletResponse.setHeader("maxAge", "10000");

        request.setAttribute("Access-Control-Request-Headers", "*");
        chain.doFilter(request, response);
    }

}