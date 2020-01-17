package com.blog.controller;

import com.blog.model.Comments;
import com.blog.service.CommentService;
import com.blog.util.ParamMap;
import com.blog.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

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
            return Response.failResponse("新增评论失败,请核对数据");
        }
        return Response.okResponse();
    }

    @RequestMapping(value="w/comments/list",method = RequestMethod.POST)
    public Response selectComment(@RequestBody ParamMap paramMap){
            String articleId = paramMap.get("articleId").toString();
            Integer count=commentService.selectCount(articleId);
            List<Comments> comments=commentService.selectByArtId(articleId);
            if(comments==null){
                return Response.failResponse("查询失败");
            }
            return Response.setResponse("list",comments).setCount(count);
    }

    @RequestMapping(value = "a/comments/alllist",method = RequestMethod.POST)
    public Response selectAll(@RequestBody ParamMap paramMap){
        Integer count=commentService.selectCount(null);
        List<Comments> comments=commentService.selectByArtId(null);
        if(comments==null){
            return Response.failResponse("查询失败");
        }
        return Response.setResponse("list",comments).setCount(count);
    }

}
