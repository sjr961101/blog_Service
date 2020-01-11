package com.blog.pojo;

public class ArticleKey {
    private Integer aid;

    private String id;

    public ArticleKey(Integer aid, String id) {
        this.aid = aid;
        this.id = id;
    }

    public ArticleKey() {
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