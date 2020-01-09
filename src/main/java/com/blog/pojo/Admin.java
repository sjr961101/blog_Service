package com.blog.pojo;

public class Admin extends AdminKey {
    private String username;

    private String password;

    private String salt;

    private String accessToken;

    private Integer tokenExpiresIn;

    private Integer createTime;

    private Boolean status;

    private Integer lastLoginTime;

    public Admin(Integer aid, String userId, String username, String password, String salt, String accessToken, Integer tokenExpiresIn, Integer createTime, Boolean status, Integer lastLoginTime) {
        super(aid, userId);
        this.username = username;
        this.password = password;
        this.salt = salt;
        this.accessToken = accessToken;
        this.tokenExpiresIn = tokenExpiresIn;
        this.createTime = createTime;
        this.status = status;
        this.lastLoginTime = lastLoginTime;
    }



    public Admin() {
        super();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt == null ? null : salt.trim();
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken == null ? null : accessToken.trim();
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