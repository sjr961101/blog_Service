package com.blog.controller;

import com.blog.model.BlogConfig;
import com.blog.model.Common;
import com.blog.service.CommonService;
import com.blog.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@CrossOrigin
@Controller
@ResponseBody
public class CommonController {
    @Autowired
    CommonService commonService;


    @RequestMapping(value = "a/statistics/home",method = RequestMethod.POST)
    public Response statistic(){
        Common common=null;
        common = commonService.statistic();
        if(common==null){
            return Response.newResponse().put("code",6).put("message","查询失败");
        }
        return Response.newResponse().setData(common);
    }

    @RequestMapping(value = "/w/blogInfo" , method = RequestMethod.POST)
    public Response getInfo(){
        BlogConfig blogConfig= commonService.blogInfo();
        Common common= commonService.statistic();
        if(blogConfig==null || common==null){
            return  Response.newResponse().put("code",666).put("message","查询失败");
        }
        blogConfig.setArticleCount(common.getPublishCount());
        blogConfig.setCategoryCount(common.getCategoryCount());
        blogConfig.setTagCount(common.getTagCount());
        return  Response.newResponse().setData(blogConfig);
    }
}
