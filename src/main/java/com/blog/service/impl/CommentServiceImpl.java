package com.blog.service.impl;

import com.blog.dao.CommentsMapper;
import com.blog.model.Comments;
import com.blog.service.CommentService;
import com.blog.util.LogUtils;
import com.blog.util.Response;
import com.blog.util.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;

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
}
