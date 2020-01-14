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
    public Integer insert(Tag record) {
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
    public Integer update(Tag record) {
        Integer count=0;
        try{
            count=tagMapper.updateById(record);
        }catch (Exception e){
            LogUtils.error(e);
            return -1;
        }
        return count;
    }

    @Override
    public Integer delete(Tag tag) {
        Integer count=0;
        try{
            if(tagMapper.delete(tag)==1){
                count=1;
            }else{
                count=tagMapper.updateById(tag);
            }
        }catch (Exception e){
            LogUtils.error(e);
            return -1;
        }
        return count;
    }
}
