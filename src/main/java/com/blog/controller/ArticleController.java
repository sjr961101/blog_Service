package com.blog.controller;



import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.blog.model.*;
import com.blog.service.ArticleService;
import com.blog.service.CategoryService;
import com.blog.util.ParamMap;
import com.blog.util.RedisUtil;
import com.blog.util.Response;
import com.qiniu.util.Auth;
import com.qiniu.util.StringMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.*;


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

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "a/qiniu/token", method = RequestMethod.POST)
    /**
     * @Description 获取 七牛云的 token
     * @param bucket 仓库名称
     * @return com.blog.model.QiNiu
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

        //新增
        if(articleService.insert(article)!=1){
            return Response.failResponse("新增失败");
        }else {
            addArtCount(article.getCategoryId(),"1");
        }
        return Response.okResponse();
    };

    @RequestMapping(value = "w/article/list", method = RequestMethod.POST)
    /**
     * @Description //TODO 分页查询文章
     * @param paramMap
     * @return com.blog.util.Response
    */
    public Response getList(@RequestBody ParamMap paramMap) {
        paramMap.setPages((int)paramMap.get("page"),(int)paramMap.get("pageSize"));
        paramMap.put("status",paramMap.get("state")!=null?(int)paramMap.get("state"):0);
        List<Article> list=null;
        //文章总数
        Integer count =0;
        //文章列表(分页)
        list=articleService.selectList(paramMap);
        count=articleService.selectByAllcount(paramMap);
        if(list!=null){
            List<Article> resList=new ArrayList<Article>();
            //判断是否按标签查找，如果是的话则筛选出符合条件的数据
            String tagId=paramMap.get("tagId")!=null?paramMap.get("tagId").toString():"";
            if(!tagId.equals("")){
                for(Article art:list){
                    for(Tag tag:art.getTags()){
                        if(tag.getTagId().equals(tagId)){
                            resList.add(art);
                            break;
                        }
                    }
                }
                return Response.setResponse("list",resList).setCount(count);
            }
            return Response.setResponse("list",list).setCount(count);
        }

        return Response.failResponse("文章查询失败");
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
        if(article!=null){
            if(redisUtil.get("blogInfo")!=null){
               BlogConfig blogConfig= JSON.parseObject(redisUtil.get("blogInfo"),BlogConfig.class);
               article.setQrcode(blogConfig);
            }else{
               Response response=restTemplate.postForObject("http://localhost:8088/Blog/w/blogInfo",null,Response.class);
               article.setQrcode(JSONObject.parseObject(JSON.toJSONString(response.getData()),BlogConfig.class));
            }
            return Response.setResponse("list",article);
        }

        return Response.failResponse();
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
        //保存
        if(articleService.insert(article)!=1){
            return Response.failResponse();
        }else {
            addArtCount(article.getCategoryId(),"1");
        }
        return Response.okResponse();
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
        article.setStatus((short)0);
        //修改
        if(articleService.updateArticle(article)!=1){
            return Response.failResponse();
        }
        return Response.okResponse();
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
        //删除   第一次删除将文章状态变为删除状态，第二次删除则删掉记录
        if(articleService.deleteArticle(article)!=1){
            return Response.failResponse();
        }
        addArtCount(article.getCategoryId(),"-1");
        //删除分类中的文章个数
//        else {
//            ParamMap paramMap =ParamMap.newMap();
//            paramMap.set("id",article.getId());
//            article=articleService.selectDetailById(paramMap);
//            addArtCount(article!=null?article.getCategoryId():null,"-1");
//        }
        return Response.okResponse();
    };

    /**
     * @Description 文章搜索
     * @param paramMap
     * @return com.blog.util.Response
    */
    @RequestMapping(value = "w/article/search",method = RequestMethod.POST)
    public Response search(@RequestBody ParamMap paramMap){
        paramMap.setPages((int)paramMap.get("page"),(int)paramMap.get("pageSize"));
        paramMap.put("status",paramMap.get("state")!=null?(int)paramMap.get("state"):0);
        List<Article> list=null;
        //文章总数
        Integer count =0;
        //文章列表(分页)
        list=articleService.selectList(paramMap);
        count=articleService.selectByAllcount(paramMap);
        if(list!=null){
            return Response.setResponse("list",list).setCount(count);
        }
        return Response.failResponse();
    }

    /**
     * @Description: 归档功能
     * @Author: 沈俊仁
     * @Date:
    */
    @RequestMapping(value = "w/article/archives",method = RequestMethod.POST)
    public Response archive(@RequestBody ParamMap paramMap){
        paramMap.setPages((int)paramMap.get("page"),(int)paramMap.get("pageSize"));
        paramMap.put("status",paramMap.get("state")!=null?(int)paramMap.get("state"):0);
        List<Article> list=null;
        //文章总数
        Integer count =0;
        //文章列表(分页)
        list=articleService.selectList(paramMap);
        count=articleService.selectByAllcount(paramMap);
        Map<String, Map<String,List<Article>>> map=null;
        //如果查到信息则按照年月存储
        if(list != null){
            map=new HashMap<>();
            for(Article article:list){
                String year=article.getCreateTime().substring(0,4);
                String month=article.getCreateTime().substring(5,7);
                //该年已有数据
                if(map.containsKey(year)){
                    Map<String,List<Article>> map1=map.get(year);
                    if(map1.containsKey(month)){
                        map1.get(month).add(article);
                    }else{
                        HashMap<String,List<Article>> newMonth=new HashMap();
                        List<Article> newList=new ArrayList<>();
                        newList.add(article);
                        map1.put(month,newList);
                    }

                }else{//该年未有数据
                    HashMap<String,List<Article>> newMonth=new HashMap();
                    List<Article> newList=new ArrayList<>();
                    newList.add(article);
                    newMonth.put(month,newList);
                    map.put(year,newMonth);
                }
            }
            Map<String,Object> result=new HashMap<>();
            result.put("count",count);
            result.put("list",map);
            result.put("page",paramMap.get("page"));
            result.put("pageSize",paramMap.get("pageSize"));
            return Response.okResponse().setData(result);
        }
        return Response.failResponse();
    }


    private Response addArtCount(String cId,String count){
        ParamMap paramMap=ParamMap.newMap();
        paramMap.set("categoryId",cId);
        paramMap.set("count",count);
        categoryService.updateArtCount(paramMap);
        return Response.okResponse();
    }
}
