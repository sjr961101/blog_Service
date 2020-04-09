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
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@CrossOrigin
@Controller
@ResponseBody
/**
 * @Description:  系统功能
 * @Author: 沈俊仁
 * @Date:
*/
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
    public Response blogInfo(){
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


    /**
     * @Description:获取博客信息
     * @Author: 沈俊仁
     * @Date:
     */
    @RequestMapping(value = "/a/webConfig" , method = RequestMethod.POST)
    public Response getWebConfig(){
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

    /**
     * @Description:修改博客信息
     * @Author: 沈俊仁
     * @Date:
     */
    @RequestMapping(value = "/a/webConfig/modify" , method = RequestMethod.POST)
    public Response modifyWebConfig(@RequestBody BlogConfig blogConfig, HttpServletRequest request){
        if(blogConfig!=null && blogConfig.getId()!=null){
            if(commonService.modifyWebConfig(blogConfig)==1){
                return  Response.okResponse();
            }
        }
        return  Response.failResponse();
    }
}
