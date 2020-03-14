package com.blog.tool.model;

public class Pages {
    private Integer id;

    private String type;

    private String md;

    private String html;

    public Pages() {
    }

    public Pages(Integer id, String type, String md, String html) {
        this.id = id;
        this.type = type;
        this.md = md;
        this.html = html;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMd() {
        return md;
    }

    public void setMd(String md) {
        this.md = md;
    }

    public String getHtml() {
        return html;
    }

    public void setHtml(String html) {
        this.html = html;
    }
}
