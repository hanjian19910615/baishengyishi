package com.zf.demo4jsp.entity;

import java.util.Date;

public class AstrologyFortune {
    private Integer id;

    private String title;

    private String content;

    private String image;

    private Date cratetime;

    public AstrologyFortune(Integer id, String title, String content, String image, Date cratetime) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.image = image;
        this.cratetime = cratetime;
    }

    public AstrologyFortune() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image == null ? null : image.trim();
    }

    public Date getCratetime() {
        return cratetime;
    }

    public void setCratetime(Date cratetime) {
        this.cratetime = cratetime;
    }
}