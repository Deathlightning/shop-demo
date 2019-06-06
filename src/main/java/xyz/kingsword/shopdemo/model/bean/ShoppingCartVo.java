package xyz.kingsword.shopdemo.model.bean;

/**
 * @author: wzh date: 2019-05-27 15:51
 * @version: 1.0
 **/
public class ShoppingCartVo {
    private int userId;
    private int goodId;
    private int nums;
    private String goodName;

    public ShoppingCartVo(int userId, int goodId, int nums, String goodName) {
        this.userId = userId;
        this.goodId = goodId;
        this.nums = nums;
        this.goodName = goodName;
    }

    public ShoppingCartVo(int goodId, int nums, String goodName) {
        this.goodId = goodId;
        this.nums = nums;
        this.goodName = goodName;
    }

    public ShoppingCartVo() {
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

    public String getGoodName() {
        return goodName;
    }

    public void setGoodName(String goodName) {
        this.goodName = goodName;
    }
}
