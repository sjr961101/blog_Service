package com.blog.center.service;


import com.blog.tool.model.Tag;
import com.blog.tool.utils.ParamMap;

import java.util.List;

public interface TagService {
    Integer insert(Tag record);

    List<Tag> selectList(ParamMap paramMap);

    Integer update(Tag record);

    Integer delete(Tag tag);
}
