package xyz.kingsword.shopdemo.model.bean;

import lombok.Data;

/**
 * @author: wzh date: 2019-04-22 08:02
 * @version: 1.0
 **/
@Data
public class User {
    private int id;
    private String username;
    private String password;
    private Integer type;//0为普通用户1为管理员用户
    private Card bankId;
    private String address;
    private String imgUrl;
    private String email;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User() {
    }


}
