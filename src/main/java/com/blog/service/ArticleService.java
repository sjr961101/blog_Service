package com.blog.service;

import com.blog.model.Article;
import com.blog.model.ArticleTag;
import com.blog.util.ParamMap;

import java.util.List;

public interface ArticleService {

    int insert(Article record);

    Integer selectByAllcount();

    List<Article> selectList(ParamMap paramMap);

    Article selectDetailById(ParamMap paramMap);

}
