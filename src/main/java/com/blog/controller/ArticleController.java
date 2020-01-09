package com.blog.controller;


import com.blog.model.*;
import com.blog.service.AdminService;
import com.blog.service.ArticleService;
import com.blog.util.ParamMap;
import com.blog.util.RedisUtil;
import com.blog.util.Response;
import com.blog.util.TimeUtil;
import com.qiniu.util.Auth;
import com.qiniu.util.StringMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.*;

@CrossOrigin
@Controller
@ResponseBody
public class ArticleController {
    @Value("${qiniu.accessKey}")
    private  String  accessKey;
    @Value("${qiniu.secretKey}")
    private  String  secretKey;

    @Resource
    private RedisUtil redisUtil;

    @Autowired
    private ArticleService articleService;

    @RequestMapping(value = "a/qiniu/token", method = RequestMethod.POST)
    /**
     * @Description 获取 七牛云的 token
     * @param bucket
     * @return com.blog.pojo.QiNiu
    */
    public QiNiu getToken(@RequestBody String bucket) {
        QiNiu qiNiu = new QiNiu();
        String accessKey = this.accessKey;
        String secretKey = this.secretKey;
        long expireSeconds = 600;   //过期时间
        StringMap putPolicy = new StringMap();
        Auth auth = Auth.create(accessKey, secretKey);
        String upToken = auth.uploadToken(bucket,null, expireSeconds,putPolicy);
        qiNiu.setKey(UUID.randomUUID().toString().replaceAll("\\-", ""));
        qiNiu.setToken(upToken);
        return qiNiu;
    };

    @RequestMapping(value = "a/article/publish", method = RequestMethod.POST)
    /**
     * @Description 发布文章
     * @param article 文章信息
     * @return com.blog.util.Response
    */
    public Response publish(@RequestBody Article article) {
        String now=TimeUtil.timeToStr("YYYY-MM-dd HH:mm:ss",new Date());
        //文章id
        article.setId("article"+ new Date().getTime());
        //创建、修改时间
        article.setCreateTime(now);
        article.setUpdateTime(now);
        article.setPageView(1);
        try{
            //新增
            if(articleService.insert(article)!=1){
                throw new NullPointerException();
            }
        }catch (NullPointerException e){
            return Response.newResponse().put("code",666).put("message","发布失败");
        }
        return Response.newResponse();
    };

    @RequestMapping(value = "w/article/list", method = RequestMethod.POST)
    public Response getList(@RequestBody ParamMap paramMap) {
        List<Article> list=null;
        //文章总数
        Integer count =0;
        //文章列表(分页)
        list=articleService.selectList(paramMap);
        count=articleService.selectByAllcount();
        Response response=Response.newResponse();
        response.put("list",list);
        response.put("count",count);
        return response;
    };

    @RequestMapping(value = "w/article", method = RequestMethod.POST)
    public Response getDetail(@RequestBody ParamMap paramMap) {
        Article article=null;
        //文章总数

        //文章列表(分页)
        article=articleService.selectDetailById(paramMap);

        Response response=Response.newResponse();
        response.put("list",article);
        return response;
    };
}
