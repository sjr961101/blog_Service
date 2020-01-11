package com.blog.pojo;

public class Comments {
    private Integer id;

    private String articleId;

    private Integer parentId;

    private Integer replyId;

    private String name;

    private String email;

    private Integer createTime;

    private Integer deleteTime;

    private Boolean status;

    private Boolean isAuthor;

    public Comments(Integer id, String articleId, Integer parentId, Integer replyId, String name, String email, Integer createTime, Integer deleteTime, Boolean status, Boolean isAuthor) {
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
    }

    public Comments() {
        super();
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
        this.articleId = articleId == null ? null : articleId.trim();
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
        this.name = name == null ? null : name.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
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

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Boolean getIsAuthor() {
        return isAuthor;
    }

    public void setIsAuthor(Boolean isAuthor) {
        this.isAuthor = isAuthor;
    }
}