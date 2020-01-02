package com.blog.pojo;

public class Article extends ArticleKey {
    private String title;

    private String categoryId;

    private Integer createTime;

    private Integer deleteTime;

    private Integer updateTime;

    private Integer publishTime;

    private Boolean status;

    private Integer pageview;

    private Boolean isEncrypt;

    public Article(Integer aid, String id, String title, String categoryId, Integer createTime, Integer deleteTime, Integer updateTime, Integer publishTime, Boolean status, Integer pageview, Boolean isEncrypt) {
        super(aid, id);
        this.title = title;
        this.categoryId = categoryId;
        this.createTime = createTime;
        this.deleteTime = deleteTime;
        this.updateTime = updateTime;
        this.publishTime = publishTime;
        this.status = status;
        this.pageview = pageview;
        this.isEncrypt = isEncrypt;
    }

    public Article() {
        super();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId == null ? null : categoryId.trim();
    }

    public Integer getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Integer createTime) {
        this.createTime = createTime;
    }

    public Integer getDeleteTime() {
        return deleteTime;
    }

    public void setDeleteTime(Integer deleteTime) {
        this.deleteTime = deleteTime;
    }

    public Integer getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Integer updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Integer publishTime) {
        this.publishTime = publishTime;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Integer getPageview() {
        return pageview;
    }

    public void setPageview(Integer pageview) {
        this.pageview = pageview;
    }

    public Boolean getIsEncrypt() {
        return isEncrypt;
    }

    public void setIsEncrypt(Boolean isEncrypt) {
        this.isEncrypt = isEncrypt;
    }
}