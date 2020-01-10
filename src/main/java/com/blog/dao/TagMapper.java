package com.blog.dao;

import com.blog.model.Tag;
import com.blog.util.ParamMap;

import java.util.List;

public interface TagMapper {

    int insert(Tag record);

    List<Tag> selectList(ParamMap paramMap);

    int updateById(Tag record);
}