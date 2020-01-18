package com.blog.dao;


import com.blog.model.Comments;
import com.blog.util.ParamMap;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CommentsMapper {
    Integer deleteByPrimaryKey(Integer id);

    Integer insertComment(Comments record);

    List<Comments> selectByArtId(ParamMap paramMap);

    Integer selectParentId(Integer id);

    Integer selectCount(@Param("id")String id);
}