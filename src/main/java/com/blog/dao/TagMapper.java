package com.blog.dao;

import com.blog.pojo.Tag;
import com.blog.pojo.TagKey;

public interface TagMapper {
    int deleteByPrimaryKey(TagKey key);

    int insert(Tag record);

    int insertSelective(Tag record);

    Tag selectByPrimaryKey(TagKey key);

    int updateByPrimaryKeySelective(Tag record);

    int updateByPrimaryKey(Tag record);
}