package com.zf.demo4jsp.entity;

public class Opinion {
    private Integer id;

    private String opinioncontact;

    private String contactinformation;

    public Opinion(Integer id, String opinioncontact, String contactinformation) {
        this.id = id;
        this.opinioncontact = opinioncontact;
        this.contactinformation = contactinformation;
    }

    public Opinion() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOpinioncontact() {
        return opinioncontact;
    }

    public void setOpinioncontact(String opinioncontact) {
        this.opinioncontact = opinioncontact == null ? null : opinioncontact.trim();
    }

    public String getContactinformation() {
        return contactinformation;
    }

    public void setContactinformation(String contactinformation) {
        this.contactinformation = contactinformation == null ? null : contactinformation.trim();
    }
}