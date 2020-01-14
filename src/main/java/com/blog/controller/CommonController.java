package com.blog.controller;

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
}
