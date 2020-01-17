package com.blog.controller;



import com.blog.model.Article;
import com.blog.model.QiNiu;
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
import java.util.Date;
import java.util.List;
import java.util.UUID;


@CrossOrigin
@Controller
@ResponseBody
/**
 * @Description: 文章方法
 * @Author: 沈俊仁
 * @Date:  2020.01
*/
public class ArticleController {
    @Value("${qiniu.accessKey}")
    private  String  accessKey;
    @Value("${qiniu.secretKey}")
    private  String  secretKey;
    @Value("${qiniu.url}")
    private  String  url;
    @Value("${qiniu.bucket}")
    private  String  bucket;

    @Resource
    private RedisUtil redisUtil;

    @Autowired
    private ArticleService articleService;

    @RequestMapping(value = "a/qiniu/token", method = RequestMethod.POST)
    /**
     * @Description 获取 七牛云的 token
     * @param bucket 仓库名称
     * @return com.blog.pojo.QiNiu
    */
    public QiNiu getToken(@RequestBody ParamMap paramMap) {
        String bucket=paramMap.get("bucket").toString();
        if(bucket.equals("")||bucket==null){
            bucket=this.bucket;
        }
        QiNiu qiNiu = new QiNiu();
        long expireSeconds = 600;   //过期时间
        StringMap putPolicy = new StringMap();
        Auth auth = Auth.create(this.accessKey, this.secretKey);
        String upToken = auth.uploadToken(bucket,null, expireSeconds,putPolicy);
        qiNiu.setKey(UUID.randomUUID().toString().replaceAll("\\-", ""));
        qiNiu.setToken(upToken);
        qiNiu.setUrl(this.url);
        return qiNiu;
    };

    @RequestMapping(value = "a/article/publish", method = RequestMethod.POST)
    /**
     * @Description 发布文章
     * @param article 文章信息
     * @return com.blog.util.Response
    */
    public Response publish(@RequestBody Article article) {
        String now=Long.toString(new Date().getTime());
        //文章id
        article.setId("article"+ new Date().getTime());
        //创建、修改时间
        article.setCreateTime(now);
        article.setUpdateTime(now);
        article.setPublishTime(now);
        Response response=Response.newResponse();
        //新增
        if(articleService.insert(article)!=1){
            response.put("code","666").put("message","新增失败");
        }
        return response;
    };

    @RequestMapping(value = "w/article/list", method = RequestMethod.POST)
    /**
     * @Description //TODO 分页查询文章
     * @param paramMap
     * @return com.blog.util.Response
    */
    public Response getList(@RequestBody ParamMap paramMap) {
        paramMap.put("page",(int)paramMap.get("page")*(int)paramMap.get("pageSize"));
        Integer state=paramMap.get("state")!=null?Integer.parseInt(paramMap.get("state").toString()):0;
        paramMap.put("state",state);
        List<Article> list=null;
        //文章总数
        Integer count =0;
        //文章列表(分页)
        list=articleService.selectList(paramMap);
        count=articleService.selectByAllcount(paramMap);
        Response response=Response.newResponse();
        response.put("list",list);
        response.put("count",count);
        return response;
    };

    @RequestMapping(value = "w/article", method = RequestMethod.POST)
    /**
     * @Description //TODO 查看文章详情
     * @param paramMap
     * @return com.blog.util.Response
    */
    public Response getDetail(@RequestBody ParamMap paramMap) {
        Article article=null;
        article=articleService.selectDetailById(paramMap);
        Response response=Response.newResponse();
        if(article!=null){
            response.put("list",article);
        }else{
            response.put("code",666).put("message","未查到该文章");
        }

        return response;
    };

    @RequestMapping(value = "a/article/save", method = RequestMethod.POST)
    /**
     * @Description 保存文章
     * @param article 文章信息
     * @return com.blog.util.Response
     */
    public Response save(@RequestBody Article article) {
        String now=Long.toString(new Date().getTime());
        //文章id
        article.setId("article"+ new Date().getTime());
        //创建、修改时间
        article.setCreateTime(now);
        article.setUpdateTime(now);
        article.setStatus((short) 2);
        Response response=Response.newResponse();
        //保存
        if(articleService.insert(article)!=1){
            response.put("code","666").put("message","保存失败");
        }
        return response;
    };


    @RequestMapping(value = "a/article/modify", method = RequestMethod.POST)
    /**
     * @Description 修改文章
     * @param article
     * @return com.blog.util.Response
    */
    public Response update(@RequestBody Article article) {
        String now=Long.toString(new Date().getTime());
        //修改时间
        article.setUpdateTime(now);
        if(article.getStatus()==0) {
            article.setPublishTime(now);
        }
        Response response=Response.newResponse();
        //修改
        if(articleService.updateArticle(article)!=1){
            response.put("code","666").put("message","修改失败");
        }
        return response;
    };

    @RequestMapping(value = "a/article/delete", method = RequestMethod.POST)
    /**
     * @Description 删除文章
     * @param article
     * @return com.blog.util.Response
    */
    public Response delete(@RequestBody Article article) {
        String now=Long.toString(new Date().getTime());
        //修改时间
        article.setDeleteTime(now);
        article.setStatus((short) 1);
        Response response=Response.newResponse();
        //删除   第一次删除将文章状态变为删除状态，第二次删除则删掉记录
        if(articleService.deleteArticle(article)!=1){
            response.put("code","666").put("message","删除失败");
        }
        return response;
    };


}
