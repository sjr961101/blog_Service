package com.blog.dao;

import com.blog.pojo.Admin;
import com.blog.pojo.AdminKey;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

public interface AdminMapper {
    int deleteByPrimaryKey(AdminKey key);

    int insert(Admin record);

    int insertSelective(Admin record);

    Admin selectByPrimaryKey(AdminKey key);

    Admin selectByName(Admin key);

    int updateByPrimaryKeySelective(Admin record);

    int updateByPrimaryKey(Admin record);
}