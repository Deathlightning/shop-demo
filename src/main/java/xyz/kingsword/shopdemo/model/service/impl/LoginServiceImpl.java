package xyz.kingsword.shopdemo.model.service.impl;

import lombok.NonNull;
import xyz.kingsword.shopdemo.model.bean.User;
import xyz.kingsword.shopdemo.model.dao.UserDao;
import xyz.kingsword.shopdemo.model.exception.LoginException;
import xyz.kingsword.shopdemo.model.service.LoginService;

/**
 * @author: wzh date: 2019-04-22 08:41
 * @version: 1.0
 **/
public class LoginServiceImpl implements LoginService {
    @Override
    public void login(@NonNull User user) throws LoginException {
        String username = user.getUsername();
        String password = user.getPassword();
        user = UserDao.getInstance().login(user);
    }

    @Override
    public void unLogin(User user) {

    }
}
