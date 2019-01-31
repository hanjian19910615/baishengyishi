package com.zf.demo4jsp.entity;

import java.util.Date;

public class Agency {
    private Integer id;

    private String industry;

    private String name;

    private String understanding;

    private String wechat;

    private String phone;

    private String idcardfrontimg;

    private String idcardfrontcontrary;

    private Date createtime;

    private String address;

    public Agency(Integer id, String industry, String name, String understanding, String wechat, String phone, String idcardfrontimg, String idcardfrontcontrary, Date createtime, String address) {
        this.id = id;
        this.industry = industry;
        this.name = name;
        this.understanding = understanding;
        this.wechat = wechat;
        this.phone = phone;
        this.idcardfrontimg = idcardfrontimg;
        this.idcardfrontcontrary = idcardfrontcontrary;
        this.createtime = createtime;
        this.address = address;
    }

    public Agency() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry == null ? null : industry.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getUnderstanding() {
        return understanding;
    }

    public void setUnderstanding(String understanding) {
        this.understanding = understanding == null ? null : understanding.trim();
    }

    public String getWechat() {
        return wechat;
    }

    public void setWechat(String wechat) {
        this.wechat = wechat == null ? null : wechat.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getIdcardfrontimg() {
        return idcardfrontimg;
    }

    public void setIdcardfrontimg(String idcardfrontimg) {
        this.idcardfrontimg = idcardfrontimg == null ? null : idcardfrontimg.trim();
    }

    public String getIdcardfrontcontrary() {
        return idcardfrontcontrary;
    }

    public void setIdcardfrontcontrary(String idcardfrontcontrary) {
        this.idcardfrontcontrary = idcardfrontcontrary == null ? null : idcardfrontcontrary.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }
}