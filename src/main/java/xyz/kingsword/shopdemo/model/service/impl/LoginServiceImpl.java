package xyz.kingsword.shopdemo.model.service.impl;

import lombok.NonNull;
import xyz.kingsword.shopdemo.model.bean.User;
import xyz.kingsword.shopdemo.model.dao.UserDao;
import xyz.kingsword.shopdemo.model.exception.LoginException;
import xyz.kingsword.shopdemo.model.exception.ParameterException;
import xyz.kingsword.shopdemo.model.service.ConditionalStrategy;
import xyz.kingsword.shopdemo.model.service.LoginService;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.Optional;

/**
 * @author: wzh date: 2019-04-22 08:41
 * @version: 1.0
 **/
@Named
public class LoginServiceImpl implements LoginService {
    @Inject
    private UserDao userDao;

    @Override
    public void login(@NonNull User user) {
//        ConditionalStrategy.conditionals(checkParameter(user)).orElseThrow();
        user = Optional.of(user).orElseThrow(ParameterException::new);
        userDao.login(user);
    }

    @Override
    public User login(String username) {
        return userDao.login(username);
    }

    private boolean checkParameter(User user) {
        return user.getUsername() != null && user.getPassword() != null;
    }
}
