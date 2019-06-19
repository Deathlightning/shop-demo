package xyz.kingsword.shopdemo.model.service.impl;

import xyz.kingsword.shopdemo.model.bean.ShoppingCart;
import xyz.kingsword.shopdemo.model.dao.ShoppingCartDao;
import xyz.kingsword.shopdemo.model.service.ShoppingCartService;

import java.util.List;

/**
 * @author: wzh date: 2019-06-01 16:30
 * @version: 1.0
 **/
public class ShoppingCartServiceImpl implements ShoppingCartService {
    private ShoppingCartDao shoppingCartDao;

    public ShoppingCartServiceImpl() {
        this.shoppingCartDao = new ShoppingCartDao();
    }


    @Override
    public void insert(int id, int userId) {
        shoppingCartDao.insert(id, userId);
    }

    @Override
    public void delete(List<Integer> goodIdList, int userId) {
        shoppingCartDao.delete(goodIdList, userId);
    }

    @Override
    public void update(List<ShoppingCart> shoppingCartList, int userId) {
        shoppingCartDao.update(shoppingCartList, userId);
    }

    @Override
    public void insert(List<Integer> ids, int userId) {
        shoppingCartDao.insert(ids, userId);
    }
}
