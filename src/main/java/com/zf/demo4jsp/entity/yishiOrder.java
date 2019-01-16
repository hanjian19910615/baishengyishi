package com.zf.demo4jsp.entity;

import java.util.Date;

public class yishiOrder {
    private Integer id;

    private String ordernumber;

    private String orderamount;

    private String ordername;

    private Date ordertime;

    private String userid;

    private String paymentstatus;

    private String solutionstate;

    private String ordertype;

    private String username;

    private String yishiid;

    private String yishiname;

    public yishiOrder(Integer id, String ordernumber, String orderamount, String ordername, Date ordertime, String userid, String paymentstatus, String solutionstate, String ordertype, String username, String yishiid, String yishiname) {
        this.id = id;
        this.ordernumber = ordernumber;
        this.orderamount = orderamount;
        this.ordername = ordername;
        this.ordertime = ordertime;
        this.userid = userid;
        this.paymentstatus = paymentstatus;
        this.solutionstate = solutionstate;
        this.ordertype = ordertype;
        this.username = username;
        this.yishiid = yishiid;
        this.yishiname = yishiname;
    }

    public yishiOrder() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrdernumber() {
        return ordernumber;
    }

    public void setOrdernumber(String ordernumber) {
        this.ordernumber = ordernumber == null ? null : ordernumber.trim();
    }

    public String getOrderamount() {
        return orderamount;
    }

    public void setOrderamount(String orderamount) {
        this.orderamount = orderamount == null ? null : orderamount.trim();
    }

    public String getOrdername() {
        return ordername;
    }

    public void setOrdername(String ordername) {
        this.ordername = ordername == null ? null : ordername.trim();
    }

    public Date getOrdertime() {
        return ordertime;
    }

    public void setOrdertime(Date ordertime) {
        this.ordertime = ordertime;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public String getPaymentstatus() {
        return paymentstatus;
    }

    public void setPaymentstatus(String paymentstatus) {
        this.paymentstatus = paymentstatus == null ? null : paymentstatus.trim();
    }

    public String getSolutionstate() {
        return solutionstate;
    }

    public void setSolutionstate(String solutionstate) {
        this.solutionstate = solutionstate == null ? null : solutionstate.trim();
    }

    public String getOrdertype() {
        return ordertype;
    }

    public void setOrdertype(String ordertype) {
        this.ordertype = ordertype == null ? null : ordertype.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getYishiid() {
        return yishiid;
    }

    public void setYishiid(String yishiid) {
        this.yishiid = yishiid == null ? null : yishiid.trim();
    }

    public String getYishiname() {
        return yishiname;
    }

    public void setYishiname(String yishiname) {
        this.yishiname = yishiname == null ? null : yishiname.trim();
    }
}