package com.lxq.pojo;

import javax.crypto.spec.PSource;
import java.io.Serializable;
import java.util.Date;

/**
 * @author 刘小七
 * @date 2019/09/16  11:28:00
 */
public class Transfer implements Serializable {

    private Integer id;
    private Double money;
    private Date tradeDate;
    private String tradeType;
    private String comment;
    private Double balance;
    private Integer uid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public Date getTradeDate() {
        return tradeDate;
    }

    public void setTradeDate(Date tradeDate) {
        this.tradeDate = tradeDate;
    }

    public String getTradeType() {
        return tradeType;
    }

    public void setTradeType(String tradeType) {
        this.tradeType = tradeType;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    @Override
    public String toString() {
        return "Transfer{" +
                "id=" + id +
                ", money=" + money +
                ", tradeDate=" + tradeDate +
                ", tradeType='" + tradeType + '\'' +
                ", comment='" + comment + '\'' +
                ", balance=" + balance +
                ", uid=" + uid +
                '}';
    }
}
