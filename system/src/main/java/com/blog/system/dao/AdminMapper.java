package com.blog.system.dao;


import com.blog.tool.model.Admin;

public interface AdminMapper {

    int insertSelective(Admin record);

    Admin selectByName(Admin key);

    int updateByPrimaryKeySelective(Admin record);

}