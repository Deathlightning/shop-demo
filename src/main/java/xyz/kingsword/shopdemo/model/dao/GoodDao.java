package xyz.kingsword.shopdemo.model.dao;

import cn.hutool.db.Db;
import cn.hutool.db.Entity;
import cn.hutool.db.Page;
import cn.hutool.db.sql.Condition;
import xyz.kingsword.shopdemo.model.bean.Good;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


/**
 * @author: wzh date: 2019-05-10 22:17
 * @version: 1.0
 **/
public class GoodDao {
    public Good findById(int id) {
        Entity where = Entity.create("good").set("id", id);
        try {
            List<Entity> entityList = Optional.ofNullable(Db.use().find(where)).orElse(new ArrayList<>());
            if (entityList.size() > 0) {
                return entityList.get(0).toBean(new Good());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean insert(Good good) {
        Entity entity = Entity.create("good").parseBean(good);
        try {
            return Db.use().insert(entity) == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean update(Good good) {
        Entity entity = Entity.create("good").parseBean(good);
        Entity where = Entity.create("good").set("id", good.getId());
        try {
            return Db.use().update(entity, where) == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean delete(int id) {
        Entity entity = Entity.create("good").set("id", id);
        try {
            return Db.use().del(entity) == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public Good findOnId(int id) {
        try {
            List<Entity> goodList = Db.use().find(Entity.create("good").set("id", id));
            if (goodList.size() != 0) {
                return goodList.get(0).toBean(new Good());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Good> findOnName(String name) {
        try {
            List<Entity> entityList = Db.use().findLike("good", "name", name, Condition.LikeType.Contains);
            return entityList.parallelStream().map(v -> v.toBeanIgnoreCase(Good.class)).collect(Collectors.toList());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    public int countOnName(String name) {
        try {
            String sql = "select count(id) from good where name like %" + name + "%";
            return Db.use().execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public List<Good> findOnType(String type) {
        try {
            List<Entity> entityList = Db.use().findAll(Entity.create("good").set("type", type));
            return entityList.parallelStream().map(v -> v.toBeanIgnoreCase(Good.class)).collect(Collectors.toList());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    public List<Good> listById(List<Integer> ids) {
        try {
            List<Entity> entityList = Db.use().findAll(Entity.create("good").set("id", ids));
            return entityList.parallelStream().map(v -> v.toBeanIgnoreCase(Good.class)).collect(Collectors.toList());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    public List<Good> listGood(Page page) {
        try {
            List<Entity> entityList = Db.use().page(Entity.create("good"), page);
            return entityList.parallelStream().map(v -> v.toBeanIgnoreCase(Good.class)).collect(Collectors.toList());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    public List<String> getClassify() {
        String[] classify = new String[11];
        classify[0] = "服装";
        classify[1] = "鞋包";
        classify[2] = "玩具";
        classify[3] = "化妆品";
        classify[4] = "珠宝 饰品";
        classify[5] = "手表 眼镜";
        classify[6] = "运动 户外";
        classify[7] = "游戏 动漫";
        classify[8] = "美食 生鲜";
        classify[9] = "花卉 宠物";
        classify[10] = "家具 装修";
        return Arrays.asList(classify);
    }


}
