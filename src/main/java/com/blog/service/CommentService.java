package com.blog.service;

import com.blog.model.Comments;
import com.blog.util.ParamMap;

import java.util.List;

public interface CommentService {
    Integer insert(Comments comments);

    Integer selectParentId(Integer id);

    List<Comments> selectByArtId(ParamMap paramMap);

    Integer selectCount(String id);
}
