package com.zf.demo4jsp.entity;

public class Slideshow {
    private Integer id;

    private String name;

    private String imagepath;

    private String url;

    private String imagetype;

    private String explain;

    public Slideshow(Integer id, String name, String imagepath, String url, String imagetype, String explain) {
        this.id = id;
        this.name = name;
        this.imagepath = imagepath;
        this.url = url;
        this.imagetype = imagetype;
        this.explain = explain;
    }

    public Slideshow() {
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

    public String getImagepath() {
        return imagepath;
    }

    public void setImagepath(String imagepath) {
        this.imagepath = imagepath == null ? null : imagepath.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getImagetype() {
        return imagetype;
    }

    public void setImagetype(String imagetype) {
        this.imagetype = imagetype == null ? null : imagetype.trim();
    }

    public String getExplain() {
        return explain;
    }

    public void setExplain(String explain) {
        this.explain = explain == null ? null : explain.trim();
    }
}