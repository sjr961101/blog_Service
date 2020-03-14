package com.blog.tool.model;

public class Tag {
    private Integer aid;

    private String tagId;

    private String tagName;

    private String createTime;

    private String updateTime;

    private Short status;

    private Integer articleCount;

    public Tag() {
    }

    public Tag(Integer aid, String tagId, String tagName, String createTime, String updateTime, Short status, Integer articleCount) {
        this.aid = aid;
        this.tagId = tagId;
        this.tagName = tagName;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.status = status;
        this.articleCount = articleCount;
    }

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public String getTagId() {
        return tagId;
    }

    public void setTagId(String tagId) {
        this.tagId = tagId;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public Integer getArticleCount() {
        return articleCount;
    }

    public void setArticleCount(Integer articleCount) {
        this.articleCount = articleCount;
    }
}
