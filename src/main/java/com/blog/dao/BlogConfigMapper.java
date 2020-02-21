package com.blog.dao;

import com.blog.model.BlogConfig;

public interface BlogConfigMapper {
    Integer deleteByPrimaryKey(Integer id);

    BlogConfig selectConfig();



}