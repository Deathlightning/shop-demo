package xyz.kingsword.shopdemo.model.service;

import cn.hutool.db.Page;
import xyz.kingsword.shopdemo.model.bean.Good;

import java.util.Collection;
import java.util.List;

public interface GoodService {
    void insert(Good good);

    void update(Good good);

    void delete(int id);

    List<Good> findOnCategory(int classify);

    List<Good> findOnName(String name);

    Good findOnId(int id);

    List<Good> list(Collection<Integer> ids);

    List<Good> list(Page page);

    List<String> getClassifyList();
}
