package com.blog.dao;

import com.blog.pojo.articleTagMapper;

public interface articleTagMapperMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(articleTagMapper record);

    int insertSelective(articleTagMapper record);

    articleTagMapper selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(articleTagMapper record);

    int updateByPrimaryKey(articleTagMapper record);
}