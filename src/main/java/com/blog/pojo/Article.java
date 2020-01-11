package com.blog.pojo;

import java.util.List;

public class Article extends ArticleKey {
    private String title;

    private String categoryId;

    private Long createTime;

    private Long deleteTime;

    private Long updateTime;

    private Long publishTime;

    private Boolean status;

    private Integer pageview;

    private Boolean isEncrypt;

    private String createTimeStr;

    private String publishTimeStr;

    private List<Tag> tags;

    private Category categories;


    public Article(Integer aid, String id, String title, String categoryId, Long createTime, Long deleteTime, Long updateTime, Long publishTime, Boolean status, Integer pageview, Boolean isEncrypt) {
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

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public Long getDeleteTime() {
        return deleteTime;
    }

    public void setDeleteTime(Long deleteTime) {
        this.deleteTime = deleteTime;
    }

    public Long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }

    public Long getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Long publishTime) {
        this.publishTime = publishTime;
    }

    public Boolean getEncrypt() {
        return isEncrypt;
    }

    public void setEncrypt(Boolean encrypt) {
        isEncrypt = encrypt;
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

    public String getCreateTimeStr() {
        return createTimeStr;
    }

    public void setCreateTimeStr(String createTimeStr) {
        this.createTimeStr = createTimeStr;
    }


    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public Category getCategories() {
        return categories;
    }

    public void setCategories(Category categories) {
        this.categories = categories;
    }

    public String getPublishTimeStr() {
        return publishTimeStr;
    }

    public void setPublishTimeStr(String publishTimeStr) {
        this.publishTimeStr = publishTimeStr;
    }
}