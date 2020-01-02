package com.blog.dao;

import com.blog.pojo.sysLog;

public interface sysLogMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(sysLog record);

    int insertSelective(sysLog record);

    sysLog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(sysLog record);

    int updateByPrimaryKeyWithBLOBs(sysLog record);

    int updateByPrimaryKey(sysLog record);
}