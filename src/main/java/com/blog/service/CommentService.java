package com.blog.service;

import com.blog.model.Comments;

public interface CommentService {
    Integer insert(Comments comments);

    Integer selectParentId(Integer id);
}
