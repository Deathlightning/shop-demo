package xyz.kingsword.shopdemo.controller.commonController;

import xyz.kingsword.shopdemo.model.exception.ParameterException;
import xyz.kingsword.shopdemo.model.util.CheckCodeUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebServlet(name = "SendCodeController", urlPatterns = "/sendCode")
public class SendCodeController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        Optional.ofNullable(email).orElseThrow(ParameterException::new);
        CheckCodeUtil.sendCode(email);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
