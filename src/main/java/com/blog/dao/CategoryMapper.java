package com.blog.dao;

import com.blog.model.Category;
import com.blog.util.ParamMap;

import java.util.List;

public interface CategoryMapper {

    List<Category> selectList(ParamMap paramMap);

    int insert(Category record);

    int updateById(Category record);
}