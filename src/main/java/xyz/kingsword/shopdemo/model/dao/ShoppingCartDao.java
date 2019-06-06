package xyz.kingsword.shopdemo.model.dao;

import cn.hutool.db.Db;
import cn.hutool.db.Entity;
import xyz.kingsword.shopdemo.model.bean.ShoppingCart;

import java.sql.SQLException;
import java.util.List;

/**
 * @author: wzh date: 2019-06-01 16:31
 * @version: 1.0
 **/
public class ShoppingCartDao {
    public void insert(int id, int userId) {
        try {
            Entity entity = Entity.create("shopping_cart").set("goods_id", id).set("user_id", userId);
            Db.use().insert(entity);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(List<Integer> goodIdList, int userId) {
        Entity where = Entity.create("shopping_cart").set("user_id", userId).set("goods_id", goodIdList);
        try {
            Db.use().del(where);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(List<ShoppingCart> shoppingCartList, int userId) {
        try {
            String[] sqls = new String[shoppingCartList.size()];
            int i = 0;
            for (ShoppingCart shoppingCart : shoppingCartList) {
                String sql = "update shopping_cart set nums=" + shoppingCart.getNums() + " where goods_id=" + shoppingCart.getGoodId() + " where user_id=" + userId;
                sqls[i++] = sql;
            }
            Db.use().executeBatch(sqls);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
