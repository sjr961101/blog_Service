package com.blog.pojo;

public class CommentsWithBLOBs extends Comments {
    private String content;

    private String sourceContent;

    public CommentsWithBLOBs(Integer id, String articleId, Integer parentId, Integer replyId, String name, String email, Integer createTime, Integer deleteTime, Boolean status, Boolean isAuthor, String content, String sourceContent) {
        super(id, articleId, parentId, replyId, name, email, createTime, deleteTime, status, isAuthor);
        this.content = content;
        this.sourceContent = sourceContent;
    }

    public CommentsWithBLOBs() {
        super();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getSourceContent() {
        return sourceContent;
    }

    public void setSourceContent(String sourceContent) {
        this.sourceContent = sourceContent == null ? null : sourceContent.trim();
    }
}