package xyz.kingsword.shopdemo.model.service.impl;

import lombok.NonNull;
import xyz.kingsword.shopdemo.model.bean.User;
import xyz.kingsword.shopdemo.model.dao.UserDao;
import xyz.kingsword.shopdemo.model.exception.ParameterException;
import xyz.kingsword.shopdemo.model.service.LoginService;

import java.util.Optional;

/**
 * @author: wzh date: 2019-04-22 08:41
 * @version: 1.0
 **/
public class LoginServiceImpl implements LoginService {

    @Override
    public User login(@NonNull User user) {
//        ConditionalStrategy.conditionals(checkParameter(user)).orElseThrow();
        UserDao userDao = new UserDao();
        user = Optional.of(user).orElseThrow(ParameterException::new);
        return userDao.login(user);
    }

    @Override
    public User login(String username) {
        UserDao userDao = new UserDao();
        return userDao.login(username);
    }

    private boolean checkParameter(User user) {
        return user.getUsername() != null && user.getPassword() != null;
    }
}
