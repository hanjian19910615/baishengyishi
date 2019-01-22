package com.zf.demo4jsp.entity;

public class EightCharacters {
    private Integer id;

    private String name;

    private String sex;

    private String birthhour;

    private String times;

    private String address;

    private String userid;

    public EightCharacters(Integer id, String name, String sex, String birthhour, String times, String address, String userid) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.birthhour = birthhour;
        this.times = times;
        this.address = address;
        this.userid = userid;
    }

    public EightCharacters() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getBirthhour() {
        return birthhour;
    }

    public void setBirthhour(String birthhour) {
        this.birthhour = birthhour == null ? null : birthhour.trim();
    }

    public String getTimes() {
        return times;
    }

    public void setTimes(String label) {
        this.times = label == null ? null : label.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }
}