package com.blog.model;

import java.util.List;

public class Article {
    private Integer aid;
    private String id;
    private String title;
    private String categoryId;
    private String createTime;
    private String deleteTime;
    private String updateTime;
    private String publishTime;
    private Short status;
    private String content;
    private String htmlContent;
    private String cover;
    private String subMessage;
    private Integer pageView;
    private Short isEncrypt;

    private List<Tag> tags;

    private Category categories;

    public Article() {
    }

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getDeleteTime() {
        return deleteTime;
    }

    public void setDeleteTime(String deleteTime) {
        this.deleteTime = deleteTime;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getHtmlContent() {
        return htmlContent;
    }

    public void setHtmlContent(String htmlContent) {
        this.htmlContent = htmlContent;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getSubMessage() {
        return subMessage;
    }

    public void setSubMessage(String subMessage) {
        this.subMessage = subMessage;
    }

    public Integer getPageView() {
        return pageView;
    }

    public void setPageView(Integer pageView) {
        this.pageView = pageView;
    }

    public Short getIsEncrypt() {
        return isEncrypt;
    }

    public void setIsEncrypt(Short isEncrypt) {
        this.isEncrypt = isEncrypt;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(String publishTime) {
        this.publishTime = publishTime;
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

    @Override
    public String toString() {
        return "Article{" +
                "aid=" + aid +
                ", id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", categoryId='" + categoryId + '\'' +
                ", createTime='" + createTime + '\'' +
                ", deleteTime='" + deleteTime + '\'' +
                ", updateTime='" + updateTime + '\'' +
                ", publishTime='" + publishTime + '\'' +
                ", status=" + status +
                ", content='" + content + '\'' +
                ", htmlContent='" + htmlContent + '\'' +
                ", cover='" + cover + '\'' +
                ", subMessage='" + subMessage + '\'' +
                ", pageView=" + pageView +
                ", isEncrypt=" + isEncrypt +
                '}';
    }
}
