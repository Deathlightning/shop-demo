package xyz.kingsword.shopdemo.controller.userController;

import xyz.kingsword.shopdemo.model.exception.CheckCodeException;
import xyz.kingsword.shopdemo.model.service.ConditionalStrategy;
import xyz.kingsword.shopdemo.model.service.UserManageService;
import xyz.kingsword.shopdemo.model.util.CheckCodeUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/resetPassword", name = "ResetPasswordServlet")
public class ResetPasswordServlet extends HttpServlet {
    private UserManageService userService;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String checkCode = request.getParameter("checkCode");
        String password = request.getParameter("password");
        boolean flag = CheckCodeUtil.cherifyCode(checkCode);
        ConditionalStrategy.ofCondition(flag).orElseThrow(CheckCodeException::new);
        userService.resetPassword(email, password);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
