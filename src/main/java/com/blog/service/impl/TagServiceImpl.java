package com.blog.service.impl;

import com.blog.dao.TagMapper;
import com.blog.model.Tag;
import com.blog.service.TagService;
import com.blog.util.LogUtils;
import com.blog.util.ParamMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagServiceImpl implements TagService {
    @Autowired(required = false)
    private TagMapper tagMapper;


    @Override
    public int insert(Tag record) {
        Integer count=0;
        try{
            count=tagMapper.insert(record);
        }catch (Exception e){
            LogUtils.error(e);
            return 0;
        }
        return count;
    }

    @Override
    public List<Tag> selectList(ParamMap paramMap) {
        List<Tag> list=null;
        try {
            list=tagMapper.selectList(paramMap);
        }catch (Exception e){
            LogUtils.error(e);
            return null;
        }
        return list;


    }

    @Override
    public int update(Tag record) {
        Integer count=0;
        try{
            count=tagMapper.updateById(record);
        }catch (Exception e){
            LogUtils.error(e);
            return -1;
        }
        return count;
    }
}
