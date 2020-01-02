package com.blog.dao;

import com.blog.pojo.Article;
import com.blog.pojo.ArticleKey;
import com.blog.pojo.ArticleWithBLOBs;

public interface ArticleMapper {
    int deleteByPrimaryKey(ArticleKey key);

    int insert(ArticleWithBLOBs record);

    int insertSelective(ArticleWithBLOBs record);

    ArticleWithBLOBs selectByPrimaryKey(ArticleKey key);

    int updateByPrimaryKeySelective(ArticleWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(ArticleWithBLOBs record);

    int updateByPrimaryKey(Article record);
}