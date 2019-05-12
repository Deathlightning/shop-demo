package xyz.kingsword.shopdemo.model.dao;

import cn.hutool.db.Db;
import cn.hutool.db.Entity;
import cn.hutool.db.sql.Condition;
import xyz.kingsword.shopdemo.model.bean.Good;

import javax.inject.Named;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


/**
 * @author: wzh date: 2019-05-10 22:17
 * @version: 1.0
 **/
@Named
public class GoodDao {
    public boolean insert(Good good) {
        Entity entity = Entity.create("goods").parseBean(good);
        try {
            return Db.use().insert(entity) == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean update(Good good) {
        Entity entity = Entity.create("goods").parseBean(good);
        Entity where = Entity.create("goods").set("id", good.getId());
        try {
            return Db.use().update(entity, where) == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean delete(int id) {
        Entity entity = Entity.create("goods").set("id", id);
        try {
            return Db.use().del(entity) == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<Good> findOnName(String name) {
        try {
            List<Entity> entityList = Db.use().findLike("goods", "name", name, Condition.LikeType.Contains);
            return entityList.parallelStream().map(v -> v.toBeanIgnoreCase(Good.class)).collect(Collectors.toList());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }


}
