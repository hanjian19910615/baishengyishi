package com.zf.demo4jsp.entity;

public class Evaluate {
    private Integer id;

    private String content;

    private String createtime;

    private String userid;

    private String username;

    private String yishiname;

    private String evaluationvalue;

    private String starlevel;

    private String yishiid;

    private String ordernumber;
    private String orderName;



    public Evaluate(Integer id, String content, String createtime,
                    String userid, String username,
                    String yishiname, String evaluationvalue,
                    String starlevel, String yishiid, String ordernumber,String orderName) {
        this.id = id;
        this.content = content;
        this.createtime = createtime;
        this.userid = userid;
        this.username = username;
        this.yishiname = yishiname;
        this.evaluationvalue = evaluationvalue;
        this.starlevel = starlevel;
        this.yishiid = yishiid;
        this.ordernumber = ordernumber;
        this.orderName = orderName;
    }

    public Evaluate() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime == null ? null : createtime.trim();
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getYishiname() {
        return yishiname;
    }

    public void setYishiname(String yishiname) {
        this.yishiname = yishiname == null ? null : yishiname.trim();
    }

    public String getEvaluationvalue() {
        return evaluationvalue;
    }

    public void setEvaluationvalue(String evaluationvalue) {
        this.evaluationvalue = evaluationvalue == null ? null : evaluationvalue.trim();
    }

    public String getStarlevel() {
        return starlevel;
    }

    public void setStarlevel(String starlevel) {
        this.starlevel = starlevel;
    }

    public String getYishiid() {
        return yishiid;
    }

    public void setYishiid(String yishiid) {
        this.yishiid = yishiid == null ? null : yishiid.trim();
    }

    public String getOrdernumber() {
        return ordernumber;
    }

    public void setOrdernumber(String ordernumber) {
        this.ordernumber = ordernumber == null ? null : ordernumber.trim();
    }
    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName == null ? null : orderName.trim();
    }
}