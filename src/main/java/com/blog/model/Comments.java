package com.blog.model;

import java.util.List;

public class Comments {
    private Integer id;

    private String articleId;

    private Integer parentId;

    private Integer replyId;

    private String name;

    private String email;

    private String createTime;

    private String deleteTime;

    private Short status;

    private Short isAuthor;

    private String content;

    private String sourceContent;

    private List<Comments> children;

    private String ip;

    private String articleTitle;



    public Comments() {
    }

    public Comments(Integer id, String articleId, Integer parentId, Integer replyId, String name, String email, String createTime, String deleteTime, Short status, Short isAuthor, String content, String sourceContent) {
        this.id = id;
        this.articleId = articleId;
        this.parentId = parentId;
        this.replyId = replyId;
        this.name = name;
        this.email = email;
        this.createTime = createTime;
        this.deleteTime = deleteTime;
        this.status = status;
        this.isAuthor = isAuthor;
        this.content = content;
        this.sourceContent = sourceContent;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getArticleId() {
        return articleId;
    }

    public void setArticleId(String articleId) {
        this.articleId = articleId;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Integer getReplyId() {
        return replyId;
    }

    public void setReplyId(Integer replyId) {
        this.replyId = replyId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getSourceContent() {
        return sourceContent;
    }

    public void setSourceContent(String sourceContent) {
        this.sourceContent = sourceContent;
    }

    public List<Comments> getChildren() {
        return children;
    }

    public void setChildren(List<Comments> children) {
        this.children = children;
    }

    public Short getIsAuthor() {
        return isAuthor;
    }

    public void setIsAuthor(Short isAuthor) {
        this.isAuthor = isAuthor;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getArticleTitle() {
        return articleTitle;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle;
    }
}
