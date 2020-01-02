package com.blog.pojo;

public class blogConfigWithBLOBs extends blogConfig {
    private String avatar;

    private String sign;

    private String wxpayQrcode;

    private String alipayQrcode;

    private String github;

    public blogConfigWithBLOBs(Integer id, String blogName, String viewPassword, String salt, String avatar, String sign, String wxpayQrcode, String alipayQrcode, String github) {
        super(id, blogName, viewPassword, salt);
        this.avatar = avatar;
        this.sign = sign;
        this.wxpayQrcode = wxpayQrcode;
        this.alipayQrcode = alipayQrcode;
        this.github = github;
    }

    public blogConfigWithBLOBs() {
        super();
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar == null ? null : avatar.trim();
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign == null ? null : sign.trim();
    }

    public String getWxpayQrcode() {
        return wxpayQrcode;
    }

    public void setWxpayQrcode(String wxpayQrcode) {
        this.wxpayQrcode = wxpayQrcode == null ? null : wxpayQrcode.trim();
    }

    public String getAlipayQrcode() {
        return alipayQrcode;
    }

    public void setAlipayQrcode(String alipayQrcode) {
        this.alipayQrcode = alipayQrcode == null ? null : alipayQrcode.trim();
    }

    public String getGithub() {
        return github;
    }

    public void setGithub(String github) {
        this.github = github == null ? null : github.trim();
    }
}