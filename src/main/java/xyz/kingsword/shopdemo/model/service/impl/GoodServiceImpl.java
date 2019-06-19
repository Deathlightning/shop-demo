package xyz.kingsword.shopdemo.model.service.impl;

import cn.hutool.db.Page;
import cn.hutool.json.JSONUtil;
import xyz.kingsword.shopdemo.model.bean.Good;
import xyz.kingsword.shopdemo.model.dao.GoodDao;
import xyz.kingsword.shopdemo.model.service.GoodService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

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
    public List<Good> findOnCategory(int classify) {
        List<Good> goodList = goodDao.findOnCategory(classify);
        return propertyConvert(goodList);
    }

    @Override
    public List<Good> findOnName(String name) {
        List<Good> goodList = goodDao.findOnName(name);
        return propertyConvert(goodList);
    }

    @Override
    public Good findOnId(int id) {
        Good good = goodDao.findById(id);
        return propertyConvert(good);
    }

    @Override
    public List<Good> list(Collection<Integer> ids) {
        if (ids.size() == 0) {
            return new ArrayList<>();
        }
        return propertyConvert(goodDao.listById(ids));
    }

    @Override
    public List<Good> list(Page page) {
        List<Good> goodList = goodDao.listGood(page);
        return propertyConvert(goodList);
    }

    @Override
    public List<String> getClassifyList() {
        return goodDao.getClassify();
    }

    private List<Good> propertyConvert(List<Good> goodList) {
        goodList.forEach(v -> {
            String photo = v.getPhotos().get(0);
            v.setPhotos(JSONUtil.parseArray(photo).toList(String.class));
            String attributesMap = v.getAttributes();
            v.setAttributesMap(JSONUtil.parseObj(attributesMap));
        });
        return goodList;
    }

    private Good propertyConvert(Good good) {
        String s = good.getPhotos().get(0);
        good.setPhotos(JSONUtil.parseArray(s).toList(String.class));
        return good;
    }
}
