package com.zf.demo4jsp.entity.myEntity;

public class EvaluateUser {
    private Integer id;
    private String userid;
    private String username;
    private String yishiid;
    private String yishiname;
    private String orderName;
    private String content;
    private String headportrait;
    private String yishiamount;
    private String createtime;
//    private String yishiimg;





    public EvaluateUser(Integer id, String userid, String username,
                        String yishiid, String yishiname
                        ,String orderName , String content
                        ,String headportrait, String yishiamount,
                         String createtime
    ) {
        this.id = id;
        this.userid = userid;
        this.username = username;
        this.yishiname = yishiname;
        this.yishiid = yishiid;
        this.orderName = orderName;
        this.content = content;
        this.headportrait = headportrait;
        this.yishiamount = yishiamount;
        this.createtime = createtime;
//        this.yishiimg = yishiimg;
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
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getYishiid() {
        return yishiid;
    }

    public void setYishiid(String yishiid) {
        this.yishiid = yishiid;
    }

    public String getYishiname() {
        return yishiname;
    }

    public void setYishiname(String yishiname) {
        this.yishiname = yishiname;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getHeadportrait() {
        return headportrait;
    }

    public void setHeadportrait(String headportrait) {
        this.headportrait = headportrait;
    }

    public String getYishiamount() {
        return yishiamount;
    }

    public void setYishiamount(String yishiamount) {
        this.yishiamount = yishiamount;
    }
//
    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }
//    public String getYishiimg() {
//        return yishiimg;
//    }
//    public void setYishiimg(String yishiimg) {
//        this.yishiimg = yishiimg;
//    }
}