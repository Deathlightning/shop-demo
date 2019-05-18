package xyz.kingsword.shopdemo.model.exception;

/**
 * @author: wzh date: 2019-05-13 08:35
 * @version: 1.0
 **/
public class DaoException extends RuntimeException {
    public DaoException() {
        super("dao exception");
    }

    public DaoException(String message) {
        super(message);
    }
}
