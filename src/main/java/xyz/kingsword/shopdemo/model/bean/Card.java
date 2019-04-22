package xyz.kingsword.shopdemo.model.bean;

import lombok.Data;

/**
 * @author: wzh date: 2019-04-22 08:44
 * @version: 1.0
 **/
@Data
public class Card {
    private String cardNo;
    private String bank;
    private String cardType;

    public Card(String cardNo, String bank, String cardType) {
        this.cardNo = cardNo;
        this.bank = bank;
        this.cardType = cardType;
    }
}
