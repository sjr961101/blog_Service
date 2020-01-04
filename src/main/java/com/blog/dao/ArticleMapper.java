package com.blog.dao;

import com.blog.pojo.Article;
import com.blog.pojo.ArticleKey;
import com.blog.pojo.ArticleWithBLOBs;
import com.blog.util.ParamMap;

import java.util.List;

public interface ArticleMapper {
    int deleteByPrimaryKey(ArticleKey key);

    int insert(ArticleWithBLOBs record);

    int insertSelective(ArticleWithBLOBs record);

    ArticleWithBLOBs selectByPrimaryKey(ArticleKey key);

    List<ArticleWithBLOBs> selectByList(ParamMap paramMap);

    Integer selectByAllcount();

    int updateByPrimaryKeySelective(ArticleWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(ArticleWithBLOBs record);

    int updateByPrimaryKey(Article record);
}