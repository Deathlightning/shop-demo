package xyz.kingsword.shopdemo.model.exception;

/**
 * @author: wzh date: 2019-04-24 20:15
 * @version: 1.0
 **/
public class ParameterException extends RuntimeException {
    public ParameterException() {
        super("wrong parameters");
    }

    public ParameterException(String message) {
        super(message);
    }
}
