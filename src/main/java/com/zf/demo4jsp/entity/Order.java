package com.zf.demo4jsp.entity;

import java.util.Date;

public class Order {
    private Integer id;
    private String ordernumber;
    private String ordername;
    private String orderamount;
    private Date ordertime;
    private String userid;
    private String paymentstatus;
    private String ordertype;
    private Integer disableenable;
    private Integer solutionstate;
    private String usertype;
    private String ordertypemx;
    private String username;
    private String yishianswers;
    public Order(Integer id, String ordernumber, String ordername, String orderamount,
                 Date ordertime, String userid, String paymentstatus, String ordertype,
                 Integer disableenable, Integer solutionstate, String usertype, String ordertypemx,
                 String username,String yishianswers) {
        this.id = id;
        this.ordernumber = ordernumber;
        this.ordername = ordername;
        this.orderamount = orderamount;
        this.ordertime = ordertime;
        this.userid = userid;
        this.paymentstatus = paymentstatus;
        this.ordertype = ordertype;
        this.disableenable = disableenable;
        this.solutionstate = solutionstate;
        this.usertype = usertype;
        this.ordertypemx = ordertypemx;
        this.username = username;
        this.yishianswers = yishianswers;
    }
    public Order() {
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
    public String getOrdername() {
        return ordername;
    }
    public void setOrdername(String ordername) {
        this.ordername = ordername == null ? null : ordername.trim();
    }
    public String getOrderamount() {
        return orderamount;
    }
    public void setOrderamount(String orderamount) {
        this.orderamount = orderamount == null ? null : orderamount.trim();
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
    public String getOrdertype() {
        return ordertype;
    }
    public void setOrdertype(String ordertype) {
        this.ordertype = ordertype == null ? null : ordertype.trim();
    }
    public Integer getDisableenable() {
        return disableenable;
    }
    public void setDisableenable(Integer disableenable) {
        this.disableenable = disableenable;
    }
    public Integer getSolutionstate() {
        return solutionstate;
    }
    public void setSolutionstate(Integer solutionstate) {
        this.solutionstate = solutionstate;
    }
    public String getUsertype() {
        return usertype;
    }
    public void setUsertype(String usertype) {
        this.usertype = usertype == null ? null : usertype.trim();
    }
    public String getOrdertypemx() {
        return ordertypemx;
    }
    public void setOrdertypemx(String ordertypemx) {
        this.ordertypemx = ordertypemx == null ? null : ordertypemx.trim();
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }
    public String getYishianswers() {
        return yishianswers;
    }
    public void setYishianswers(String yishianswers) {
        this.yishianswers = yishianswers == null ? null : yishianswers.trim();
    }

}