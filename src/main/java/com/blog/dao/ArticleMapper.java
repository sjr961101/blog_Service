package com.blog.dao;

import com.blog.model.Article;
import com.blog.pojo.ArticleWithBLOBs;
import com.blog.util.ParamMap;

import java.util.List;

public interface ArticleMapper {

    int insert(Article record);

    Integer selectByAllcount(ParamMap paramMap);

    List<Article> selectList(ParamMap paramMap);

    Article selectDetailById(ParamMap paramMap);

    Integer addpageView(ParamMap paramMap);

    Integer updateArticle(Article article);

    Integer deleteArticle(Article article);
}