package com.blog.controller;

import com.blog.model.Comments;
import com.blog.service.CommentService;
import com.blog.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@CrossOrigin
@Controller
@ResponseBody
public class CommentController {
    @Autowired
    CommentService commentService;

    @RequestMapping(value = "w/comments/add",method = RequestMethod.POST)
    public Response insertComment(@RequestBody Comments comments){
        if(comments.getReplyId()!=0){
            int parentId=commentService.selectParentId(comments.getReplyId());
            comments.setParentId(parentId!=0?parentId:comments.getReplyId());
        }else{
            comments.setParentId(0);
        }
        comments.setCreateTime(String.valueOf(new Date().getTime()));
        if(commentService.insert(comments)!=1){
            return Response.newResponse().put("code","666").put("message","评论失败");
        }
        return Response.newResponse();
    }

    public Response selectComment(@RequestBody Integer articleId){
            return Response.newResponse();
    }

}
