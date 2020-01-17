package com.blog.service.impl;

import com.blog.dao.CommentsMapper;
import com.blog.model.Comments;
import com.blog.service.CommentService;
import com.blog.util.LogUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired(required = false)
    CommentsMapper commentsMapper;


    @Override
    public Integer insert(Comments comments) {
        Integer count=0;
        try{
            count=commentsMapper.insertComment(comments);
        }catch (Exception e){
            LogUtils.error(e);
            return null;
        }
        return count;
    }

    @Override
    public Integer selectParentId(Integer id) {
        Integer count=0;
        try{
            count=commentsMapper.selectParentId(id);
        }catch (Exception e){
            LogUtils.error(e);
            return null;
        }
        return count;
    }

    @Override
    public List<Comments> selectByArtId(String id) {
        List<Comments> comments=null;
        try{
            comments=commentsMapper.selectByArtId(id);
        }catch (Exception e){
            LogUtils.error(e);
            return null;
        }
        return comments;
    }

    @Override
    public Integer selectCount(String id) {
        Integer count=0;
        try{
            count=commentsMapper.selectCount(id);
        }catch (Exception e){
            LogUtils.error(e);
            return null;
        }
        return count;
    }
}
