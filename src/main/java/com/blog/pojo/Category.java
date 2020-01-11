package com.blog.pojo;

public class Category extends CategoryKey {
    private String name;

    private Integer createTime;

    private Integer updateTime;

    private Boolean status;

    private Integer articleCount;

    private Boolean canDel;

    public Category(Integer aid, String id, String name, Integer createTime, Integer updateTime, Boolean status, Integer articleCount, Boolean canDel) {
        super(aid, id);
        this.name = name;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.status = status;
        this.articleCount = articleCount;
        this.canDel = canDel;
    }

    public Category() {
        super();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Integer createTime) {
        this.createTime = createTime;
    }

    public Integer getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Integer updateTime) {
        this.updateTime = updateTime;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Integer getArticleCount() {
        return articleCount;
    }

    public void setArticleCount(Integer articleCount) {
        this.articleCount = articleCount;
    }

    public Boolean getCanDel() {
        return canDel;
    }

    public void setCanDel(Boolean canDel) {
        this.canDel = canDel;
    }
}