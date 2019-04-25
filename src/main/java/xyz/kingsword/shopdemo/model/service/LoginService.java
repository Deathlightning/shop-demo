package xyz.kingsword.shopdemo.model.service;

import xyz.kingsword.shopdemo.model.bean.User;
import xyz.kingsword.shopdemo.model.exception.LoginException;

import javax.inject.Named;

public interface LoginService {
    void login(User user) throws LoginException;

    User login(String username);
}
