package com.blog.service;

import com.blog.pojo.ArticleWithBLOBs;
import com.blog.util.ParamMap;

import java.util.List;

public interface ArticleService {
    int insert(ArticleWithBLOBs record);

    List<ArticleWithBLOBs> selectByList(ParamMap paramMap);

    Integer selectByAllcount();
}
