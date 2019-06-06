package xyz.kingsword.shopdemo.model.service;

import xyz.kingsword.shopdemo.model.bean.ShoppingCart;

import java.util.List;

/**
 * @author: wzh date: 2019-06-01 16:27
 * @version: 1.0
 **/
public interface ShoppingCartService {
    void insert(int id, int userId);

    void delete(List<Integer> goodIdList, int userId);

    void update(List<ShoppingCart> shoppingCartList, int userId);

    void insert(List<Integer> ids, int userId);
}
