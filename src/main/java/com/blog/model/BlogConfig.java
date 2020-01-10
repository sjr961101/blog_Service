package com.blog.model;

public class BlogConfig {
    private Integer id;

    private String blogName;

    private String viewPassword;

    private String salt;

    private String avatar;

    private String sign;

    private String wxpayQrcode;

    private String alipayQrcode;

    private String github;

    public BlogConfig(Integer id, String blogName, String viewPassword, String salt, String avatar, String sign, String wxpayQrcode, String alipayQrcode, String github) {
        this.id = id;
        this.blogName = blogName;
        this.viewPassword = viewPassword;
        this.salt = salt;
        this.avatar = avatar;
        this.sign = sign;
        this.wxpayQrcode = wxpayQrcode;
        this.alipayQrcode = alipayQrcode;
        this.github = github;
    }

    public BlogConfig() {
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
        this.blogName = blogName;
    }

    public String getViewPassword() {
        return viewPassword;
    }

    public void setViewPassword(String viewPassword) {
        this.viewPassword = viewPassword;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getWxpayQrcode() {
        return wxpayQrcode;
    }

    public void setWxpayQrcode(String wxpayQrcode) {
        this.wxpayQrcode = wxpayQrcode;
    }

    public String getAlipayQrcode() {
        return alipayQrcode;
    }

    public void setAlipayQrcode(String alipayQrcode) {
        this.alipayQrcode = alipayQrcode;
    }

    public String getGithub() {
        return github;
    }

    public void setGithub(String github) {
        this.github = github;
    }
}
