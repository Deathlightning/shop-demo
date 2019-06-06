package xyz.kingsword.shopdemo.controller.userController;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.extra.servlet.ServletUtil;
import xyz.kingsword.shopdemo.model.bean.User;
import xyz.kingsword.shopdemo.model.service.LoginService;
import xyz.kingsword.shopdemo.model.service.ShoppingCartService;
import xyz.kingsword.shopdemo.model.service.impl.LoginServiceImpl;
import xyz.kingsword.shopdemo.model.service.impl.ShoppingCartServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet(name = "LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    private ShoppingCartService shoppingCartService;

    @Override
    @SuppressWarnings("unchecked")
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        LoginService loginService = new LoginServiceImpl();
        Map<String, String> map = ServletUtil.getParamMap(request);
        boolean autoLogin = map.remove("autoLogin") != null;
        User user = BeanUtil.mapToBean(map, User.class, false);
        user = loginService.login(user);
        request.getSession().setAttribute("user", user);
        if (autoLogin) {
            ServletUtil.addCookie(response, new Cookie("user", user.getUsername()));
        }
        List<Integer> goodIdList = (List<Integer>) request.getSession().getAttribute("shoppingCartList");
        if (goodIdList != null) {
            shoppingCartService.insert(goodIdList, user.getId());
        }
        response.sendRedirect(request.getContextPath() + "/index.jsp");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        doPost(request, response);
    }

    @Override
    public void init() {
        this.shoppingCartService = new ShoppingCartServiceImpl();
    }
}
