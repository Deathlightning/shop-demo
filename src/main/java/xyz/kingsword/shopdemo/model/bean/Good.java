package xyz.kingsword.shopdemo.model.bean;

import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * @author: wzh date: 2019-04-22 08:03
 * @version: 1.0
 **/
@Data
public class Good {
    private int id;
    private String name;
    private List<String> photos;
    private String description;
    private double price;
    private int number;
    private int category;
    private String attributes;
    private Map<String, Object> attributesMap;

}
