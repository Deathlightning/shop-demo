package xyz.kingsword.shopdemo.model.bean;

import lombok.Data;

/**
 * @author: wzh date: 2019-04-22 08:03
 * @version: 1.0
 **/
@Data
public class Good {
    private int id;
    private String name;
    private String photo;
    private String description;
    private double price;
    private int number;
    private String classify;
    private String attributes;

}
