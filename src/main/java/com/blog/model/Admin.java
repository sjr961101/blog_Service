package com.blog.model;

public class Admin {
    private Integer aid;

    private String userId;

    private String username;

    private String password;

    private String salt;

    private String accessToken;

    private Integer tokenExpiresIn;

    private Integer createTime;

    private Boolean status;

    private Integer lastLoginTime;

    public Admin() {
    }

    public Admin(Integer aid, String userId, String username, String password, String salt, String accessToken, Integer tokenExpiresIn, Integer createTime, Boolean status, Integer lastLoginTime) {
        this.aid = aid;
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.salt = salt;
        this.accessToken = accessToken;
        this.tokenExpiresIn = tokenExpiresIn;
        this.createTime = createTime;
        this.status = status;
        this.lastLoginTime = lastLoginTime;
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
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public Integer getTokenExpiresIn() {
        return tokenExpiresIn;
    }

    public void setTokenExpiresIn(Integer tokenExpiresIn) {
        this.tokenExpiresIn = tokenExpiresIn;
    }

    public Integer getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Integer createTime) {
        this.createTime = createTime;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Integer getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Integer lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }
}
