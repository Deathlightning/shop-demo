package xyz.kingsword.shopdemo.model.dao;

import cn.hutool.db.Db;
import cn.hutool.db.Entity;
import cn.hutool.db.Page;
import xyz.kingsword.shopdemo.model.bean.Category;

import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: wzh date: 2019-06-17 15:35
 * @version: 1.0
 **/
public class CategoryDao {
    public int insert(Category category) {
        int flag = 0;
        try {
            flag = Db.use().insert(Entity.parse(category).setTableName("category"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }

    public int delete(int id) {
        int flag = 0;
        try {
            flag = Db.use().update(Entity.create("category").set("status", -1), Entity.create("category").set("id", id));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }

    public int move(int id, int parentId) {
        int flag = 0;
        try {
            flag = Db.use().update(Entity.create("category").set("parentId", parentId), Entity.create("category").set("id", id));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }

    public List<Category> listCategoryOnName(String name, Page page) {
        List<Category> categoryList = null;
        try {
            categoryList = Db.use().page(Entity.create("category").set("catName", name), page).parallelStream().map(v -> v.toBean(new Category())).collect(Collectors.toList());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categoryList;
    }

    public List<Category> listCategoryOnParent(int parentId, Page page) {
        List<Category> categoryList = null;
        try {
            categoryList = Db.use().page(Entity.create("category").set("parentId", parentId), page).parallelStream().map(v -> v.toBean(new Category())).collect(Collectors.toList());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categoryList;
    }

    public List<Category> listCategory() {
        List<Category> categoryList = null;
        try {
            categoryList = Db.use().find(Entity.create("category").set("status", "0")).parallelStream().map(v -> v.toBean(new Category())).collect(Collectors.toList());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categoryList;
    }
}
