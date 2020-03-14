package com.blog.center.service.impl;



import com.blog.center.service.ArticleService;
import com.blog.tool.model.Article;
import com.blog.tool.utils.ParamMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {


    @Override
    public int insert(Article record) {
        return 0;
    }

    @Override
    public Integer selectByAllcount(ParamMap paramMap) {
        return null;
    }

    @Override
    public List<Article> selectList(ParamMap paramMap) {
        return null;
    }

    @Override
    public Article selectDetailById(ParamMap paramMap) {
        return null;
    }

    @Override
    public Integer updateArticle(Article article) {
        return null;
    }

    @Override
    public Integer deleteArticle(Article article) {
        return null;
    }
}
