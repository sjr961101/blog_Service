package com.blog.service;

import com.blog.model.Category;
import com.blog.util.ParamMap;

import java.util.List;

public interface CategoryService {
    List<Category> selectList(ParamMap paramMap);

    Integer insert(Category record);

    Integer updateById(Category record);

    Integer deleteCategory(Category category);

    Integer updateArtCount(ParamMap paramMap);
}
