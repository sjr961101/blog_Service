package com.blog.controller;

import com.blog.pojo.Admin;
import com.blog.service.AdminService;
import com.blog.util.RedisUtil;
import com.blog.util.Response;
import com.blog.util.TimeUtil;
import com.blog.util.TokenUtil;
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
public class AdminController {
    @Resource
    private RedisUtil redisUtil;
    @Autowired
    AdminService adminService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Response initInsert(@RequestBody Admin admin){
        String pwd=admin.getPassword();
        try{
            admin = adminService.selectByName(admin);
            if(admin!=null){
                if(!admin.getPassword().equals(pwd)){
                    return Response.newResponse().put("code", -4001).put("message", "用户名或密码错误");
                }
            }else{
                return Response.newResponse().put("code", -4001).put("message", "未查到该用户");
            }
        }catch (Exception e){
            return Response.newResponse().put("code", -4001).put("message", "未知错误");
        }
        Map data =new HashMap();
        String token=TokenUtil.produceToken(admin.getUsername());
        data.put("username",admin.getUsername());
        data.put("access_token",token);
        redisUtil.set(token, TimeUtil.timeToStr("HHmmss",new Date()));
        return Response.newResponse().setData(data);
    }
}
