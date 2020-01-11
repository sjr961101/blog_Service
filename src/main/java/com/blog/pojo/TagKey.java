package com.blog.pojo;

public class TagKey {
    private Integer aid;

    private String id;

    public TagKey(Integer aid, String id) {
        this.aid = aid;
        this.id = id;
    }

    public TagKey() {
        super();
    }

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }
}