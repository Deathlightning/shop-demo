package xyz.kingsword.shopdemo.model.bean;

/**
 * @author: wzh date: 2019-05-26 21:34
 * @version: 1.0
 **/
public class ShoppingCart {
    private int userId;
    private int goodId;
    private int nums;

    public ShoppingCart(int goodId, int nums) {
        this.goodId = goodId;
        this.nums = nums;
    }

    public ShoppingCart(int userId, int goodId, int nums) {
        this.userId = userId;
        this.goodId = goodId;
        this.nums = nums;
    }

    public ShoppingCart() {
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getGoodId() {
        return goodId;
    }

    public void setGoodId(int goodId) {
        this.goodId = goodId;
    }

    public int getNums() {
        return nums;
    }

    public void setNums(int nums) {
        this.nums = nums;
    }

    @Override
    public String toString() {
        return "Shopping_cart{" +
                "userId=" + userId +
                ", goodId=" + goodId +
                ", nums=" + nums +
                '}';
    }
}
