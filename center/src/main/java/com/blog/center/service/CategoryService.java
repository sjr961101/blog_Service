package com.blog.center.service;


import com.blog.tool.model.Category;
import com.blog.tool.utils.ParamMap;

import java.util.List;

public interface CategoryService {
    List<Category> selectList(ParamMap paramMap);

    Integer insert(Category record);

    Integer updateById(Category record);

    Integer deleteCategory(Category category);

    Integer updateArtCount(ParamMap paramMap);
}
