package xyz.kingsword.shopdemo.controller.userController;

import xyz.kingsword.shopdemo.model.bean.User;
import xyz.kingsword.shopdemo.model.dao.UserDao;
import xyz.kingsword.shopdemo.model.exception.ParameterException;
import xyz.kingsword.shopdemo.model.util.CheckCodeUtil;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

/**
 * @author: wzh date: 2019-05-18 17:25
 * @version: 1.0
 **/
@WebServlet(value = "/sendCheckCode", name = "sendCheckCode")
public class SendCodeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        String username = req.getParameter("username");
        Optional.ofNullable(username).orElseThrow(ParameterException::new);
        User user = new UserDao().login(username);
        Optional<User> userOptional = Optional.ofNullable(user);
        req.setAttribute("errorMessage", "该用户不存在");
        userOptional.ifPresent(v -> CheckCodeUtil.sendCode(user.getEmail()));
        resp.setStatus(500);
    }
}
