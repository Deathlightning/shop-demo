package xyz.kingsword.shopdemo.model.service.impl;

import cn.hutool.db.Page;
import xyz.kingsword.shopdemo.model.bean.Category;
import xyz.kingsword.shopdemo.model.dao.CategoryDao;
import xyz.kingsword.shopdemo.model.service.CategoryService;

import java.util.*;
import java.util.stream.Collectors;

public class CategoryServiceImpl implements CategoryService {
    private CategoryDao categoryDao;

    public CategoryServiceImpl() {
        this.categoryDao = new CategoryDao();
    }

    @Override
    public void insert(Category category) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void move(int id, int parentId) {

    }

    @Override
    public List<Category> listOnParent(int parentId, Page page) {
        return null;
    }

    @Override
    public List<Category> listOnName(String name, Page page) {
        return null;
    }

    @Override
    public List<Category> listCategory(Page page) {
        return null;
    }

    @Override
    public Map<Category, List<Category>> listCategory() {
        List<Category> categories = categoryDao.listCategory();
        System.out.println("类目数量：" + categories.size());
        //按父类目id进行分类
        Map<Integer, List<Category>> map = categories.stream().collect(Collectors.groupingBy(Category::getParentId));
        Map<Category, List<Category>> categoryMap = new HashMap<>();
        List<Category> patentCategoryList = map.remove(0);
        patentCategoryList = Optional.ofNullable(patentCategoryList).orElse(new ArrayList<>());
        patentCategoryList.forEach(v -> {
            //从map中取出父id与当前对象id相同的list
            List<Category> childCategoryList = map.get(v.getCatId());
            categoryMap.put(v, childCategoryList);
        });
        return categoryMap;
    }
}