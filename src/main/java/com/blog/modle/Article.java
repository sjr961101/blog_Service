package com.blog.modle;

public class Article {
    private Integer aid;
    private String id;
    private String title;
    private String CategoryId;
    private Integer createTime;
    private Integer deleteTime;
    private Integer updateTime;
    private Integer PublishTime;
    private Short status;
    private String content;
    private String htmlContent;
    private String cover;
    private String subMessage;
    private Integer pageView;
    private Short isEncrypt;

    public Article(Integer aid, String id, String title, String categoryId, Integer createTime, Integer deleteTime, Integer updateTime, Integer publishTime, Short status, String content, String htmlContent, String cover, String subMessage, Integer pageView, Short isEncrypt) {
        this.aid = aid;
        this.id = id;
        this.title = title;
        CategoryId = categoryId;
        this.createTime = createTime;
        this.deleteTime = deleteTime;
        this.updateTime = updateTime;
        PublishTime = publishTime;
        this.status = status;
        this.content = content;
        this.htmlContent = htmlContent;
        this.cover = cover;
        this.subMessage = subMessage;
        this.pageView = pageView;
        this.isEncrypt = isEncrypt;
    }

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

    public String getCategoryId() {
        return CategoryId;
    }

    public void setCategoryId(String categoryId) {
        CategoryId = categoryId;
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
        return PublishTime;
    }

    public void setPublishTime(Integer publishTime) {
        PublishTime = publishTime;
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

    @Override
    public String toString() {
        return "Article{" +
                "aid=" + aid +
                ", id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", CategoryId='" + CategoryId + '\'' +
                ", createTime=" + createTime +
                ", deleteTime=" + deleteTime +
                ", updateTime=" + updateTime +
                ", PublishTime=" + PublishTime +
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
