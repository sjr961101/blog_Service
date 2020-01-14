package com.blog.dao;


import com.blog.model.Comments;

public interface CommentsMapper {
    Integer deleteByPrimaryKey(Integer id);

    Integer insertComment(Comments record);

    Comments selectByPrimaryKey(Integer id);

    Integer selectParentId(Integer id);
}