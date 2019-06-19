package xyz.kingsword.shopdemo.model.exception;

/**
 * @author: wzh date: 2019-06-08 13:52
 * @version: 1.0
 **/
public class CheckCodeException extends RuntimeException {
    public CheckCodeException() {

    }

    public CheckCodeException(String message) {
        super(message);
    }
}
