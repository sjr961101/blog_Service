package com.blog.service.impl;


import com.blog.dao.ArticleMapper;

import com.blog.dao.ArticleTagMapper;
import com.blog.dao.CategoryMapper;
import com.blog.model.Article;
import com.blog.model.ArticleTag;
import com.blog.model.Tag;
import com.blog.service.ArticleService;
import com.blog.util.LogUtils;
import com.blog.util.ParamMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired(required = false)
    ArticleMapper articleMapper;

    @Autowired(required = false)
    ArticleTagMapper articleTagMapper;

    @Autowired(required = false)
    private CategoryMapper categoryMapper;

    @Override
    public int insert(Article record) {
        Integer count=0;
        try{
            count=articleMapper.insert(record);
            if(count==1&&record.getTags()!=null){
                //查看文章中的标签将对于关系存贮
                changeTag(record,(short)1);
                updateArtCount(record.getCategoryId(),"1");
            }
        }catch (Exception e){
            TransactionAspectSupport.currentTransactionStatus()
                    .setRollbackOnly();
            LogUtils.error(e);
            return 0;
        }
        return count;
    }

    @Override
    public Integer selectByAllcount(ParamMap paramMap) {
        Integer count=0;
        try{
            count=articleMapper.selectByAllcount(paramMap);
        }catch (Exception e){
            LogUtils.error(e);
            return 0;
        }
        return count;
    }

    @Override
    public List<Article> selectList(ParamMap paramMap) {
        List<Article> list=null;
        try {
            list=articleMapper.selectList(paramMap);
        }catch (Exception e){
            LogUtils.error(e);
            return null;
        }
        return list;
    }

    @Override
    public Article selectDetailById(ParamMap paramMap) {
        Article article=null;
        try {
            article=articleMapper.selectDetailById(paramMap);
            if(article != null){
                articleMapper.addpageView(paramMap);
            }
        }catch (Exception e){
            LogUtils.error(e);
            return null;
        }
        return article;
    }

    @Override
    public Integer updateArticle(Article article) {
        Integer count = 0;
        try {
            count = articleMapper.updateArticle(article);
            if(count==1&&article.getTags()!=null){
                //查看文章中的标签将对于关系存贮
                changeTag(article,(short)2);
            }
        } catch (Exception e) {
            LogUtils.error(e);
            return 0;
        }
        return count;
    }

    @Override
    public Integer deleteArticle(Article article) {
        Integer count=0;
        try{
            if(articleMapper.deleteArticle(article)==1){
                ArticleTag at=new ArticleTag();
                at.setArticleId(article.getId());
                count=articleTagMapper.delete(at);
            }else{
                count=articleMapper.updateArticle(article);
                if(count==1) {
                    updateArtCount(article.getCategoryId(), "-1");
                }
            }
        }catch (Exception e){
            TransactionAspectSupport.currentTransactionStatus()
                    .setRollbackOnly();
            LogUtils.error(e);
            return -1;
        }
        return count;
    }

    private void changeTag(Article record,short flag) throws SQLException{
        List<Tag> list=record.getTags();
        ArticleTag articleTag=null;
        //如果为更新则先删除原有标签再添加新标签
        if(flag==2){
            articleTag=new ArticleTag();
            articleTag.setArticleId(record.getId());
            articleTagMapper.delete(articleTag);
        }
        for(Tag tag:list){
            articleTag=new ArticleTag(record.getId(),tag.getTagId(),String.valueOf(new Date().getTime()));
            if(articleTagMapper.insert(articleTag)!=1){
                throw new SQLException();
            }
        }

    }

    Integer updateArtCount(String cId,String count) {
        ParamMap paramMap=ParamMap.newMap();
        paramMap.set("categoryId",cId);
        paramMap.set("count",count);
        int count1=0;
        try{
            count1=categoryMapper.updateArtCount(paramMap);
        }catch (Exception e){
            LogUtils.error(e);
            return -1;
        }
        return count1;
    }

}
