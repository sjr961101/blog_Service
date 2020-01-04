package com.blog.pojo;

public class ArticleWithBLOBs extends Article {
    private String content;

    private String htmlContent;

    private String cover;

    private String subMessage;

    public ArticleWithBLOBs(Integer aid, String id, String title, String categoryId, Long createTime, Long deleteTime, Long updateTime, Long publishTime, Boolean status, Integer pageview, Boolean isEncrypt, String content, String htmlContent, String cover, String subMessage) {
        super(aid, id, title, categoryId, createTime, deleteTime, updateTime, publishTime, status, pageview, isEncrypt);
        this.content = content;
        this.htmlContent = htmlContent;
        this.cover = cover;
        this.subMessage = subMessage;
    }

    public ArticleWithBLOBs() {
        super();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getHtmlContent() {
        return htmlContent;
    }

    public void setHtmlContent(String htmlContent) {
        this.htmlContent = htmlContent == null ? null : htmlContent.trim();
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover == null ? null : cover.trim();
    }

    public String getSubMessage() {
        return subMessage;
    }

    public void setSubMessage(String subMessage) {
        this.subMessage = subMessage == null ? null : subMessage.trim();
    }
}