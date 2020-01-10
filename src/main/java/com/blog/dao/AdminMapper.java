package com.blog.dao;

import com.blog.model.Admin;

public interface AdminMapper {

    int insertSelective(Admin record);

    Admin selectByName(Admin key);

    int updateByPrimaryKeySelective(Admin record);

}