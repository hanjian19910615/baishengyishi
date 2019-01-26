package com.zf.demo4jsp.entity;

public class Coupon {
    private Integer id;

    private String userid;

    private String amount;

    public Coupon(Integer id, String userid, String amount) {
        this.id = id;
        this.userid = userid;
        this.amount = amount;
    }

    public Coupon() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount == null ? null : amount.trim();
    }
}