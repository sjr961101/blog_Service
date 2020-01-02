package com.blog.dao;

import com.blog.pojo.Admin;
import com.blog.pojo.AdminKey;

public interface AdminMapper {
    int deleteByPrimaryKey(AdminKey key);

    int insert(Admin record);

    int insertSelective(Admin record);

    Admin selectByPrimaryKey(AdminKey key);

    int updateByPrimaryKeySelective(Admin record);

    int updateByPrimaryKey(Admin record);
}