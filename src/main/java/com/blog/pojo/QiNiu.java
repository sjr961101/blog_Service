package com.blog.pojo;

public class QiNiu {
    private String token;
    private String key;

    public QiNiu(String token, String key) {
        this.token = token;
        this.key = key;
    }

    public QiNiu() {
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
