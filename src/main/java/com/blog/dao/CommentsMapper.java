package com.blog.dao;


import com.blog.model.Comments;

import java.util.List;

public interface CommentsMapper {
    Integer deleteByPrimaryKey(Integer id);

    Integer insertComment(Comments record);

    List<Comments> selectByArtId(String id);

    Integer selectParentId(Integer id);

    Integer selectCount(String id);
}