package com.blog.center.api;


import com.blog.center.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.List;

@CrossOrigin
@Controller
@ResponseBody
public class CommentController {
    @Autowired
    CommentService commentService;

//    /**
//     * @Description: 发布/回复评论
//     * @Author: 沈俊仁
//     * @Date:
//    */
//    @RequestMapping(value = "w/comments/add",method = RequestMethod.POST)
//    public Response insertComment(@RequestBody Comments comments, HttpServletRequest request){
//        String ip=getIp(request);
//        if(comments.getReplyId()!=0){
//            int parentId=commentService.selectParentId(comments.getReplyId());
//            comments.setParentId(parentId!=0?parentId:comments.getReplyId());
//        }else{
//            comments.setParentId(0);
//        }
//        comments.setCreateTime(String.valueOf(new Date().getTime()));
//        comments.setIp(ip);
//        if(commentService.insert(comments)!=1){
//            return Response.failResponse("新增评论失败,请核对数据");
//        }
//        return Response.okResponse();
//    }
//
//    /**
//     * @Description: 获取评论列表
//     * @Author: 沈俊仁
//     * @Date:
//    */
//    @RequestMapping(value="w/comments/list",method = RequestMethod.POST)
//    public Response selectComment(@RequestBody ParamMap paramMap){
//            String articleId = paramMap.get("articleId").toString();
//            Integer count=commentService.selectCount(articleId);
//            List<Comments> comments=commentService.selectByArtId(paramMap);
//            if(comments==null){
//                return Response.failResponse("查询失败");
//            }
//            return Response.setResponse("list",comments).setCount(count);
//    }
//
//    /**
//     * @Description: 获取所有评论
//     * @Author: 沈俊仁
//     * @Date:
//    */
//    @RequestMapping(value = "a/comments/alllist",method = RequestMethod.POST)
//    public Response selectAll(@RequestBody ParamMap paramMap){
//        Integer count=commentService.selectCount(null);
//        List<Comments> comments=commentService.selectByArtId(paramMap);
//        if(comments==null){
//            return Response.failResponse("查询失败");
//        }
//        return Response.setResponse("list",comments).setCount(count);
//    }
//
//
//    public String getIp(HttpServletRequest request){
//        String ip = request.getHeader("x-forwarded-for");
//        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
//            ip = request.getHeader("Proxy-Client-IP");
//        }
//        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
//            ip = request.getHeader("WL-Proxy-Client-IP");
//        }
//        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
//            ip = request.getHeader("HTTP_CLIENT_IP");
//        }
//        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
//            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
//        }
//        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
//            ip = request.getRemoteAddr();
//            if("127.0.0.1".equals(ip)||"0:0:0:0:0:0:0:1".equals(ip)){
//                //根据网卡取本机配置的IP
//                InetAddress inet=null;
//                try {
//                    inet = InetAddress.getLocalHost();
//                } catch (UnknownHostException e) {
//                    e.printStackTrace();
//                }
//                ip= inet.getHostAddress();
//            }
//        }
//        return ip;
//    }
}
