package com.blog.dao;

import com.blog.model.Tag;
import com.blog.util.ParamMap;

import java.util.List;

public interface TagMapper {

    Integer insert(Tag record);

    List<Tag> selectList(ParamMap paramMap);

    Integer updateById(Tag record);

    Integer delete(Tag tag);
}