package com.blog.pojo;

public class AdminKey {
    private Integer aid;

    private String userId;

    public AdminKey(Integer aid, String userId) {
        this.aid = aid;
        this.userId = userId;
    }

    public AdminKey() {
        super();
    }

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }
}