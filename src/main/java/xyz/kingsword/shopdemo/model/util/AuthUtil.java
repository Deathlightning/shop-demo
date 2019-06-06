package xyz.kingsword.shopdemo.model.util;

import xyz.kingsword.shopdemo.model.exception.LoginException;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

/**
 * @author: wzh date: 2019-05-26 21:28
 * @version: 1.0
 **/
public class AuthUtil {
    public static void AuthException(HttpServletRequest request) {
        Object user = request.getSession().getAttribute("user");
        Optional.ofNullable(user).orElseThrow(LoginException::new);
    }

    public static boolean LoginStatus(HttpServletRequest request) {
        Object user = request.getSession().getAttribute("user");
        return Optional.ofNullable(user).isPresent();
    }
}
