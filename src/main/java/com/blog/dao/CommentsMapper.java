package com.blog.dao;

import com.blog.pojo.Comments;
import com.blog.pojo.CommentsWithBLOBs;

public interface CommentsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CommentsWithBLOBs record);

    int insertSelective(CommentsWithBLOBs record);

    CommentsWithBLOBs selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CommentsWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(CommentsWithBLOBs record);

    int updateByPrimaryKey(Comments record);
}