package com.blog.service;

import com.blog.model.Tag;

import com.blog.util.ParamMap;

import java.util.List;

public interface TagService {
    int insert(Tag record);

    List<Tag> selectList(ParamMap paramMap);

    int update(Tag record);
}
