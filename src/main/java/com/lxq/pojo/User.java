package com.lxq.pojo;


import java.io.Serializable;
import java.util.List;

/**
 * @author 刘小七
 * @date 2019/09/16  11:27:00
 */
public class User implements Serializable {

    private Integer id;
    private String cardId;
    private String password;
    private Double balance;
    private Integer state;
    private List<Transfer> transfers;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public List<Transfer> getTransfers() {
        return transfers;
    }

    public void setTransfers(List<Transfer> transfers) {
        this.transfers = transfers;
    }
}
