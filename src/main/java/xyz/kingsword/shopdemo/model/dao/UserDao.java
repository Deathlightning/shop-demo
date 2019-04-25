package xyz.kingsword.shopdemo.model.dao;

import cn.hutool.db.Db;
import cn.hutool.db.DbUtil;
import cn.hutool.db.Entity;
import xyz.kingsword.shopdemo.model.bean.User;
import xyz.kingsword.shopdemo.model.exception.LoginException;

import javax.inject.Named;
import java.security.PublicKey;
import java.sql.SQLException;
import java.util.Optional;

/**
 * @author: wzh date: 2019-04-22 09:04
 * @version: 1.0
 **/
@Named
public class UserDao {

    public User login(User user) {
        Entity entity = null;
        try {
            entity = Db.use().queryOne("select * from user where username= ? and password= ?", user.getUsername(), user.getPassword());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Optional.ofNullable(entity).orElseThrow(LoginException::new);
        return entity.toBean(user);
    }

    public User login(String username) {
        Entity entity = null;
        try {
            entity = Db.use().queryOne("select * from user where username= ?", username);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Optional.ofNullable(entity).orElseThrow(LoginException::new);
        return entity.toBean(new User());
    }
}
