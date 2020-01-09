package com.blog.service;

import com.blog.model.Category;
import com.blog.util.ParamMap;

import java.util.List;

public interface CategoryService {
    List<Category> selectList(ParamMap paramMap);

    int insert(Category record);
}
