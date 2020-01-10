package com.blog.dao;

import com.blog.model.ArticleTag;

public interface ArticleTagMapper {
    Integer delete(Integer id);

    Integer insert(ArticleTag record);


}