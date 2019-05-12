package xyz.kingsword.shopdemo.model.service.impl;

import xyz.kingsword.shopdemo.model.bean.User;
import xyz.kingsword.shopdemo.model.dao.UserDao;
import xyz.kingsword.shopdemo.model.service.UserManageService;

import javax.inject.Inject;

/**
 * @author: wzh date: 2019-05-10 21:55
 * @version: 1.0
 **/
public class UserManageImpl implements UserManageService {
    @Inject
    private UserDao userDao;

    @Override
    public void resetPassword(String username, String password) {
        userDao.resetPassword(username, password);
    }

    @Override
    public void register(User user) {
        userDao.register(user);
    }
}
