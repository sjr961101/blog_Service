package com.blog.service.impl;

import com.blog.dao.CategoryMapper;
import com.blog.model.Category;
import com.blog.service.CategoryService;
import com.blog.util.LogUtils;
import com.blog.util.ParamMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired(required = false)
    private CategoryMapper categoryMapper;

    @Override
    public  List<Category> selectList(ParamMap paramMap) {
        List<Category> list=null;
        try {
            list=categoryMapper.selectList(paramMap);
        }catch (Exception e){
            LogUtils.error(e);
            return null;
        }
        return list;


    }

    @Override
    public Integer insert(Category record) {
        Integer count=0;
        try{
            count=categoryMapper.insert(record);
        }catch (Exception e){
            LogUtils.error(e);
            return 0;
        }
        return count;
    }

    @Override
    public Integer updateById(Category record) {
        Integer count=0;
        try{
            count=categoryMapper.updateById(record);
        }catch (Exception e){
            LogUtils.error(e);
            return -1;
        }
        return count;
    }

    @Override
    public Integer deleteCategory(Category category) {
        Integer count=0;
        try{
            if(categoryMapper.deleteCategory(category)==1){
                count=1;
            }else{
                count=categoryMapper.updateById(category);
            }
        }catch (Exception e){
            LogUtils.error(e);
            return -1;
        }
        return count;
    }

    @Override
    public Integer updateArtCount(ParamMap paramMap) {
        Integer count=0;
        try{
            categoryMapper.updateArtCount(paramMap);
        }catch (Exception e){
            LogUtils.error(e);
            return -1;
        }
        return count;
    }


}
