package xyz.kingsword.shopdemo.model.bean;

import lombok.Data;

@Data
public class Category {
    private int catId;
    private String catName;
    private int parentId;
    private int status;
    private int num;

    public Category(String catName, int parentId) {
        this.catName = catName;
        this.parentId = parentId;
    }

    public Category() {
    }
}
