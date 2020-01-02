package com.blog.dao;

import com.blog.pojo.Category;
import com.blog.pojo.CategoryKey;

public interface CategoryMapper {
    int deleteByPrimaryKey(CategoryKey key);

    int insert(Category record);

    int insertSelective(Category record);

    Category selectByPrimaryKey(CategoryKey key);

    int updateByPrimaryKeySelective(Category record);

    int updateByPrimaryKey(Category record);
}