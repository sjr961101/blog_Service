package com.blog.pojo;

public class blogConfig {
    private Integer id;

    private String blogName;

    private String viewPassword;

    private String salt;

    public blogConfig(Integer id, String blogName, String viewPassword, String salt) {
        this.id = id;
        this.blogName = blogName;
        this.viewPassword = viewPassword;
        this.salt = salt;
    }

    public blogConfig() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBlogName() {
        return blogName;
    }

    public void setBlogName(String blogName) {
        this.blogName = blogName == null ? null : blogName.trim();
    }

    public String getViewPassword() {
        return viewPassword;
    }

    public void setViewPassword(String viewPassword) {
        this.viewPassword = viewPassword == null ? null : viewPassword.trim();
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt == null ? null : salt.trim();
    }
}