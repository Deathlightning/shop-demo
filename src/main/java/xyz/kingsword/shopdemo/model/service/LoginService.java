package xyz.kingsword.shopdemo.model.service;

import xyz.kingsword.shopdemo.model.bean.User;
import xyz.kingsword.shopdemo.model.exception.LoginException;

public interface LoginService {
    void login(User user) throws LoginException;

    void unLogin(User user);
}
