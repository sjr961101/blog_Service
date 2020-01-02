package com.blog.dao;

import com.blog.pojo.blogConfig;
import com.blog.pojo.blogConfigWithBLOBs;

public interface blogConfigMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(blogConfigWithBLOBs record);

    int insertSelective(blogConfigWithBLOBs record);

    blogConfigWithBLOBs selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(blogConfigWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(blogConfigWithBLOBs record);

    int updateByPrimaryKey(blogConfig record);
}