package xyz.kingsword.shopdemo.model.service;

import xyz.kingsword.shopdemo.model.bean.Good;

import java.util.List;

public interface GoodService {
    void insert(Good good);

    void update(Good good);

    void delete(int id);

    List<Good> findOnType(String type);

    List<Good> findOnName(String name);
}
