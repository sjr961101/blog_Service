package com.blog.dao;

import com.blog.pojo.Pages;
import com.blog.pojo.PagesWithBLOBs;

public interface PagesMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PagesWithBLOBs record);

    int insertSelective(PagesWithBLOBs record);

    PagesWithBLOBs selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PagesWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(PagesWithBLOBs record);

    int updateByPrimaryKey(Pages record);
}