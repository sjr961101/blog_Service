package com.blog.pojo;

public class articleTagMapper {
    private Integer id;

    private String articleId;

    private String tagId;

    private Integer createTime;

    public articleTagMapper(Integer id, String articleId, String tagId, Integer createTime) {
        this.id = id;
        this.articleId = articleId;
        this.tagId = tagId;
        this.createTime = createTime;
    }

    public articleTagMapper() {
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

    public String getTagId() {
        return tagId;
    }

    public void setTagId(String tagId) {
        this.tagId = tagId == null ? null : tagId.trim();
    }

    public Integer getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Integer createTime) {
        this.createTime = createTime;
    }
}