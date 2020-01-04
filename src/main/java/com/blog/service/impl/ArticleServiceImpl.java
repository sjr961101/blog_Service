package com.blog.service.impl;


import com.blog.dao.ArticleMapper;
import com.blog.pojo.ArticleWithBLOBs;
import com.blog.service.ArticleService;
import com.blog.util.LogUtils;
import com.blog.util.ParamMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired(required = false)
    ArticleMapper articleMapper;

    @Override
    public int insert(ArticleWithBLOBs record) {
        Integer count=0;
        try{
             count=articleMapper.insert(record);
        }catch (Exception e){
            LogUtils.error(e);
            return 0;
        }
        return count;
    }

    @Override
    public List<ArticleWithBLOBs> selectByList(ParamMap paramMap) {
        List<ArticleWithBLOBs> list=null;
        try {
            list=articleMapper.selectByList(paramMap);
        }catch (Exception e){
            LogUtils.error(e);
            return null;
        }
        return list;
    }

    @Override
    public Integer selectByAllcount() {
        Integer count=0;
        try{
            count=articleMapper.selectByAllcount();
        }catch (Exception e){
            LogUtils.error(e);
            return 0;
        }
        return count;
    }


}
