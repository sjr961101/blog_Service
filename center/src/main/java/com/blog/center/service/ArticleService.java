package com.blog.center.service;


import com.blog.tool.model.Article;
import com.blog.tool.utils.ParamMap;

import java.util.List;

public interface ArticleService {

    int insert(Article record);

    Integer selectByAllcount(ParamMap paramMap);

    List<Article> selectList(ParamMap paramMap);

    Article selectDetailById(ParamMap paramMap);

    Integer updateArticle(Article article);

    Integer deleteArticle(Article article);


}
