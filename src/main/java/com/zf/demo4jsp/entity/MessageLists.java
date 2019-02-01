package com.zf.demo4jsp.entity;

public class MessageLists {
    private Integer id;

    private String title;

    private String content;

    private String state;

    private String cratetime;

    private String type;
    private String  countState;

    public MessageLists(Integer id, String title, String content,
                        String state, String cratetime,
                        String type,String countState) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.state = state;
        this.cratetime = cratetime;
        this.type = type;
        this.countState = countState;
    }

    public MessageLists() {
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

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    public String getCratetime() {
        return cratetime;
    }

    public void setCratetime(String cratetime) {
        this.cratetime = cratetime == null ? null : cratetime.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getCountState() {
        return countState;
    }

    public void setCountState(String countState) {
        this.countState = countState == null ? null : countState.trim();
    }

}