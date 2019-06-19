package xyz.kingsword.shopdemo.model.service;

import cn.hutool.db.Page;
import xyz.kingsword.shopdemo.model.bean.Category;

import java.util.List;
import java.util.Map;

public interface CategoryService {
    void insert(Category category);

    void delete(int id);

    void move(int id, int parentId);

    List<Category> listOnParent(int parentId, Page page);

    List<Category> listOnName(String name, Page page);

    List<Category> listCategory(Page page);

    Map<Category, List<Category>> listCategory();
}
