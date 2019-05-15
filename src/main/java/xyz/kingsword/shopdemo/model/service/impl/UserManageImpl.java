package xyz.kingsword.shopdemo.model.service.impl;

import xyz.kingsword.shopdemo.model.bean.User;
import xyz.kingsword.shopdemo.model.dao.UserDao;
import xyz.kingsword.shopdemo.model.exception.DaoException;
import xyz.kingsword.shopdemo.model.service.ConditionalStrategy;
import xyz.kingsword.shopdemo.model.service.UserManageService;

/**
 * @author: wzh date: 2019-05-10 21:55
 * @version: 1.0
 **/
public class UserManageImpl implements UserManageService {

    @Override
    public void resetPassword(String username, String password) {
        UserDao userDao = new UserDao();
        boolean flag = userDao.resetPassword(username, password);
        ConditionalStrategy.ofCondition(flag).orElseThrow(DaoException::new);
    }

    @Override
    public void register(User user) {
        UserDao userDao = new UserDao();
        userDao.register(user);
    }
}
