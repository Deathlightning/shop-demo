package xyz.kingsword.shopdemo.controller.userController;

import xyz.kingsword.shopdemo.model.bean.User;
import xyz.kingsword.shopdemo.model.exception.LoginException;
import xyz.kingsword.shopdemo.model.service.UserManageService;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebServlet(value = "/resetPasswordServlet", name = "ResetPasswordServlet")
public class ResetPasswordServlet extends HttpServlet {
    @Resource
    private UserManageService userService;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        Optional.ofNullable(user).orElseThrow(LoginException::new);
        String password = request.getParameter("password");
        userService.resetPassword(user.getUsername(), password);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
