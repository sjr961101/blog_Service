package com.blog.center.service.service.impl;


import com.blog.center.service.CategoryService;
import com.blog.tool.model.Category;
import com.blog.tool.utils.ParamMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {


    @Override
    public List<Category> selectList(ParamMap paramMap) {
        return null;
    }

    @Override
    public Integer insert(Category record) {
        return null;
    }

    @Override
    public Integer updateById(Category record) {
        return null;
    }

    @Override
    public Integer deleteCategory(Category category) {
        return null;
    }

    @Override
    public Integer updateArtCount(ParamMap paramMap) {
        return null;
    }
}
