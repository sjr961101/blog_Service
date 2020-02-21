package com.blog.dao;

import com.blog.model.Category;
import com.blog.util.ParamMap;

import java.util.List;

public interface CategoryMapper {

    List<Category> selectList(ParamMap paramMap);

    Integer insert(Category record);

    Integer updateById(Category record);

    Integer deleteCategory(Category category);

    Integer updateArtCount(ParamMap paramMap);
}