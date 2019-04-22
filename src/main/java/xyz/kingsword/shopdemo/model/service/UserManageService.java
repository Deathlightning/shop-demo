package xyz.kingsword.shopdemo.model.service;

import xyz.kingsword.shopdemo.model.bean.User;

/**
 * @author: wzh date: 2019-04-22 11:28
 * @version: 1.0
 **/
public interface UserManageService {
    User resetPassword(String username);
}
