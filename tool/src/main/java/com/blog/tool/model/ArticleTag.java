package com.blog.tool.model;

public class ArticleTag {
    private Integer id;

    private String articleId;

    private String tagId;

    private String createTime;

    public ArticleTag() {
    }

    public ArticleTag(String articleId, String tagId, String  createTime) {
        this.articleId = articleId;
        this.tagId = tagId;
        this.createTime = createTime;
    }

    public ArticleTag(Integer id, String articleId, String tagId, String createTime) {
        this.id = id;
        this.articleId = articleId;
        this.tagId = tagId;
        this.createTime = createTime;
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

    public String getTagId() {
        return tagId;
    }

    public void setTagId(String tagId) {
        this.tagId = tagId == null ? null : tagId.trim();
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}
