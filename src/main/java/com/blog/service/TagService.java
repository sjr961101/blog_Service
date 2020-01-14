package com.blog.service;

import com.blog.model.Tag;

import com.blog.util.ParamMap;

import java.util.List;

public interface TagService {
    Integer insert(Tag record);

    List<Tag> selectList(ParamMap paramMap);

    Integer update(Tag record);

    Integer delete(Tag tag);
}
