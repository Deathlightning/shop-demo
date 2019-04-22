package xyz.kingsword.shopdemo.model.exception;

/**
 * @author: wzh date: 2019-04-22 08:17
 * @version: 1.0
 **/
public class LoginException extends RuntimeException {
    public LoginException(String message) {
        super(message);
    }

    public LoginException() {
        super();
    }
}
