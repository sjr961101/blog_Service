package com.blog.pojo;

public class Tag extends TagKey {
    private String name;

    private Integer createTime;

    private Integer updateTime;

    private Boolean status;

    private Integer articleCount;

    public Tag(Integer aid, String id, String name, Integer createTime, Integer updateTime, Boolean status, Integer articleCount) {
        super(aid, id);
        this.name = name;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.status = status;
        this.articleCount = articleCount;
    }

    public Tag() {
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

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Integer getArticleCount() {
        return articleCount;
    }

    public void setArticleCount(Integer articleCount) {
        this.articleCount = articleCount;
    }
}