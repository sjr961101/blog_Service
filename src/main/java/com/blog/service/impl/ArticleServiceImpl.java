package com.blog.service.impl;


import com.blog.dao.ArticleMapper;

import com.blog.model.Article;
import com.blog.service.ArticleService;
import com.blog.util.LogUtils;
import com.blog.util.ParamMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired(required = false)
    ArticleMapper articleMapper;

    @Override
    public int insert(Article record) {
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

    @Override
    public List<Article> selectList(ParamMap paramMap) {
        List<Article> list=null;
        try {
            list=articleMapper.selectList(paramMap);
        }catch (Exception e){
            LogUtils.error(e);
            return null;
        }
        return list;
    }

    @Override
    public Article selectDetailById(ParamMap paramMap) {
        Article article=null;
        try {
            article=articleMapper.selectDetailById(paramMap);
            if(article != null){
                articleMapper.addpageView(paramMap);
            }
        }catch (Exception e){
            LogUtils.error(e);
            return null;
        }
        return article;
    }


}
