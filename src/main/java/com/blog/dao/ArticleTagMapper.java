package com.blog.dao;

import com.blog.model.ArticleTag;

public interface ArticleTagMapper {
    Integer delete(ArticleTag tag);

    Integer insert(ArticleTag record);


}