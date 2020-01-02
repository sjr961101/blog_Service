package com.blog.pojo;

public class Pages {
    private Integer id;

    private String type;

    public Pages(Integer id, String type) {
        this.id = id;
        this.type = type;
    }

    public Pages() {
        super();
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
        this.type = type == null ? null : type.trim();
    }
}