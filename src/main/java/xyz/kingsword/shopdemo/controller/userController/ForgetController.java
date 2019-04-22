package xyz.kingsword.shopdemo.controller.userController;

import cn.hutool.extra.servlet.ServletUtil;
import xyz.kingsword.shopdemo.model.bean.User;
import xyz.kingsword.shopdemo.model.service.LoginService;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author: wzh date: 2019-04-22 11:26
 * @version: 1.0
 **/
@WebServlet(urlPatterns = "/forgetUrl")
public class ForgetController extends HttpServlet {
    @Resource
    private LoginService loginService;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = ServletUtil.fillBean(request, new User(), false);
        loginService.login(user);
        request.getSession().setAttribute("user", user);
        request.getRequestDispatcher(request.getContextPath() + "/userIndex.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
