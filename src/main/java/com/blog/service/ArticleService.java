package com.blog.service;

import com.blog.model.Article;
import com.blog.model.ArticleTag;
import com.blog.util.ParamMap;

import java.util.List;

public interface ArticleService {

    int insert(Article record);

    Integer selectByAllcount(ParamMap paramMap);

    List<Article> selectList(ParamMap paramMap);

    Article selectDetailById(ParamMap paramMap);

    Integer updateArticle(Article article);

    Integer deleteArticle(Article article);

    Integer deleteTag(ArticleTag articleTag);

}
