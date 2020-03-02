package com.blog.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.blog.model.BlogConfig;
import com.blog.model.Common;
import com.blog.service.CommonService;
import com.blog.util.RedisUtil;
import com.blog.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@CrossOrigin
@Controller
@ResponseBody
public class CommonController {
    @Autowired
    CommonService commonService;

    @Resource
    private RedisUtil redisUtil;

    /** 
     * @Description: 获取数据数量
     * @Author: 沈俊仁
     * @Date:  
    */ 
    @RequestMapping(value = "a/statistics/home",method = RequestMethod.POST)
    public Response statistic(){
        Common common=null;
        common = commonService.statistic();
        if(common==null){
            return Response.failResponse("查询失败");
        }
        return Response.setResponse(common);
    }

    /**
     * @Description:获取博客信息
     * @Author: 沈俊仁
     * @Date:
    */
    @RequestMapping(value = "/w/blogInfo" , method = RequestMethod.POST)
    public Response getInfo(){
        BlogConfig blogConfig=null;
        if(redisUtil.get("blogInfo")!=null){
            blogConfig=JSON.parseObject(redisUtil.get("blogInfo"),BlogConfig.class);
        }else {
            blogConfig = commonService.blogInfo();
            Common common = commonService.statistic();
            if (blogConfig == null || common == null) {
                return Response.failResponse("查询失败");
            }
            blogConfig.setArticleCount(common.getPublishCount());
            blogConfig.setCategoryCount(common.getCategoryCount());
            blogConfig.setTagCount(common.getTagCount());
            redisUtil.set("blogInfo", JSON.toJSONString(blogConfig).toString());
        }
        return  Response.setResponse(blogConfig);
    }
}
