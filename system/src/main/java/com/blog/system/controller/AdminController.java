package com.blog.system.controller;


import com.blog.system.service.AdminService;
import com.blog.tool.model.Admin;
import com.blog.tool.utils.RedisUtil;
import com.blog.tool.utils.Response;
import com.blog.tool.utils.TimeUtil;
import com.blog.tool.utils.TokenUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@CrossOrigin
@Controller
@ResponseBody
/**
 * @Description: 用户方法
 * @Author: 沈俊仁
 * @Date:  2020.01
*/
public class AdminController {
    @Resource
    private RedisUtil redisUtil;
    @Autowired
    AdminService adminService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    /**
     * @Description //TODO 登录
     * @param admin
     * @return com.blog.util.Response
    */
    public Response initInsert(@RequestBody Admin admin){
        String pwd=admin.getPassword();
        try{
            //取出用户进行密码对比
            admin = adminService.selectByName(admin);
            if(admin!=null){
                if(!admin.getPassword().equals(pwd)){
                    return Response.failResponse().setCodeAndMessage(-4001,"用户名或密码错误");
                }
            }else{
                return Response.failResponse().setCodeAndMessage(-4001,"未查到该用户");
            }
        }catch (Exception e){
            return Response.failResponse().setCodeAndMessage(-4001,"系统错误，锤管理员查看日志");
        }
        //返回信息
        Map data =new HashMap();
        //生成的token
        String token= TokenUtil.produceToken(admin.getUserId());
        data.put("username",admin.getUsername());
        data.put("userId",admin.getUserId());
        data.put("access_token",token);  //生产的token
        data.put("isAuthor",1);  //是否是作者
        redisUtil.set(token, TimeUtil.timeToStr("HHmmss",new Date()));
        return Response.setResponse(data);
    }
}
