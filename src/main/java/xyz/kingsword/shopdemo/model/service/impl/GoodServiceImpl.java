package xyz.kingsword.shopdemo.model.service.impl;

import xyz.kingsword.shopdemo.model.bean.Good;
import xyz.kingsword.shopdemo.model.dao.GoodDao;
import xyz.kingsword.shopdemo.model.service.GoodService;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: wzh date: 2019-05-26 21:13
 * @version: 1.0
 **/
public class GoodServiceImpl implements GoodService {
    private GoodDao goodDao;

    public GoodServiceImpl() {
        goodDao = new GoodDao();
    }

    @Override
    public void insert(Good good) {
        goodDao.insert(good);
    }

    @Override
    public void update(Good good) {
        goodDao.update(good);
    }

    @Override
    public void delete(int id) {
        goodDao.delete(id);
    }

    @Override
    public List<Good> findOnType(String type) {
        return goodDao.findOnType(type);
    }

    @Override
    public List<Good> findOnName(String name) {
        return goodDao.findOnName(name);
    }

    @Override
    public Good findOnId(int id) {
        return goodDao.findById(id);
    }

    @Override
    public List<Good> list(List<Integer> ids) {
        if (ids.size() == 0) {
            return new ArrayList<>();
        }
        return goodDao.listById(ids);
    }

    @Override
    public List<String> getClassifyList() {
        return goodDao.getClassify();
    }
}
