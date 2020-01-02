package com.blog.pojo;

public class Friends extends FriendsKey {
    private String name;

    private Integer createTime;

    private Integer updateTime;

    private Integer deleteTime;

    private Boolean status;

    private Integer typeId;

    private String url;

    public Friends(Integer aid, String friendId, String name, Integer createTime, Integer updateTime, Integer deleteTime, Boolean status, Integer typeId, String url) {
        super(aid, friendId);
        this.name = name;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.deleteTime = deleteTime;
        this.status = status;
        this.typeId = typeId;
        this.url = url;
    }

    public Friends() {
        super();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Integer createTime) {
        this.createTime = createTime;
    }

    public Integer getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Integer updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getDeleteTime() {
        return deleteTime;
    }

    public void setDeleteTime(Integer deleteTime) {
        this.deleteTime = deleteTime;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }
}