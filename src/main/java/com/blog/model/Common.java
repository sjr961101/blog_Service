package com.blog.model;

public class Common {
    private Integer publishCount;

    private Integer draftsCount;

    private Integer deletedCount;

    private Integer categoryCount;

    private Integer tagCount;

    private Integer commentsCount;

    public Common(Integer publishCount, Integer draftsCount, Integer deletedCount, Integer categoryCount, Integer tagCount, Integer commentsCount) {
        this.publishCount = publishCount;
        this.draftsCount = draftsCount;
        this.deletedCount = deletedCount;
        this.categoryCount = categoryCount;
        this.tagCount = tagCount;
        this.commentsCount = commentsCount;
    }

    public Common() {
    }

    public Integer getPublishCount() {
        return publishCount;
    }

    public void setPublishCount(Integer publishCount) {
        this.publishCount = publishCount;
    }

    public Integer getDraftsCount() {
        return draftsCount;
    }

    public void setDraftsCount(Integer draftsCount) {
        this.draftsCount = draftsCount;
    }

    public Integer getDeletedCount() {
        return deletedCount;
    }

    public void setDeletedCount(Integer deletedCount) {
        this.deletedCount = deletedCount;
    }

    public Integer getCategoryCount() {
        return categoryCount;
    }

    public void setCategoryCount(Integer categoryCount) {
        this.categoryCount = categoryCount;
    }

    public Integer getTagCount() {
        return tagCount;
    }

    public void setTagCount(Integer tagCount) {
        this.tagCount = tagCount;
    }

    public Integer getCommentsCount() {
        return commentsCount;
    }

    public void setCommentsCount(Integer commentsCount) {
        this.commentsCount = commentsCount;
    }
}
