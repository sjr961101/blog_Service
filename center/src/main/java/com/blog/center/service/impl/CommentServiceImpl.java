package com.blog.center.service.impl;


import com.blog.center.service.CommentService;
import com.blog.tool.model.Comments;
import com.blog.tool.utils.ParamMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {


    @Override
    public Integer insert(Comments comments) {
        return null;
    }

    @Override
    public Integer selectParentId(Integer id) {
        return null;
    }

    @Override
    public List<Comments> selectByArtId(ParamMap paramMap) {
        return null;
    }

    @Override
    public Integer selectCount(String id) {
        return null;
    }
}
