package com.blog.dao;

import com.blog.model.Category;
import com.blog.util.ParamMap;

import java.util.List;

public interface CategoryMapper {


    int insertSelective(Category record);
    int updateByPrimaryKeySelective(Category record);
    int updateByPrimaryKey(Category record);


    List<Category> selectList(ParamMap paramMap);

    int insert(Category record);
}