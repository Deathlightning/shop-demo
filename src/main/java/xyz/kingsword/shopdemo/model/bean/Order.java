package xyz.kingsword.shopdemo.model.bean;

import lombok.Data;

import java.util.Date;

/**
 * @author: wzh date: 2019-06-10 08:41
 * @version: 1.0
 **/
@Data
public class Order {
    private int id;
    private Date buyDate;
    private String address;
    private String goodsInfo;
    private double price;
}
