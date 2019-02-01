package com.zf.demo4jsp.entity.myEntity;



public class yishiOrderEvaluate {
    private Integer id;
    private String userid;
    private String username;
    private String yishiid;
    private String yishiname;
    private String imgpath;
    private String starlevel;



    public yishiOrderEvaluate(Integer id, String userid, String username,
                    String yishiid, String yishiname,
                              String imgpath ,String starlevel) {
        this.id = id;
        this.userid = userid;
        this.username = username;
        this.yishiname = yishiname;
        this.starlevel = starlevel;
        this.yishiid = yishiid;
        this.imgpath = imgpath;

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

    public String getImgpath() {
        return imgpath;
    }

    public void setImgpath(String imgpath) {
        this.imgpath = imgpath;
    }

    public String getStarlevel() {
        return starlevel;
    }

    public void setStarlevel(String starlevel) {
        this.starlevel = starlevel;
    }



}