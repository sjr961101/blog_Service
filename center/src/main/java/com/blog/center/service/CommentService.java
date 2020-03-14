package com.blog.center.service;


import com.blog.tool.model.Comments;
import com.blog.tool.utils.ParamMap;


import java.util.List;

public interface CommentService {
    Integer insert(Comments comments);

    Integer selectParentId(Integer id);

    List<Comments> selectByArtId(ParamMap paramMap);

    Integer selectCount(String id);
}
