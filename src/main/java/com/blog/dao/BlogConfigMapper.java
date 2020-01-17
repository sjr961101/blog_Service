package com.blog.dao;

import com.blog.model.BlogConfig;
import com.blog.pojo.blogConfigWithBLOBs;

public interface BlogConfigMapper {
    Integer deleteByPrimaryKey(Integer id);

    BlogConfig selectConfig();

    Integer insertSelective(blogConfigWithBLOBs record);

    Integer updateByPrimaryKeySelective(blogConfigWithBLOBs record);


}