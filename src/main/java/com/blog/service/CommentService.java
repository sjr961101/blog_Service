package com.blog.service;

import com.blog.model.Comments;

import java.util.List;

public interface CommentService {
    Integer insert(Comments comments);

    Integer selectParentId(Integer id);

    List<Comments> selectByArtId(String id);

    Integer selectCount(String id);
}
