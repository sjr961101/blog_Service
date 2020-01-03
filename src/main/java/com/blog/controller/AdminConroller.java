package com.blog.controller;

import com.blog.pojo.Admin;
import com.blog.service.AdminService;
import com.blog.util.RedisUtil;
import com.blog.util.Response;
import com.blog.util.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@CrossOrigin
@Controller
@ResponseBody
public class AdminConroller {
    @Resource
    private RedisUtil redisUtil;
    @Autowired
    AdminService adminService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Response initInsert(@RequestBody Admin admin) throws Exception {
        Map data = new HashMap();
        data.put("username",admin.getUsername());
        admin = adminService.selectByName(admin);
        data.put("access_token", TokenUtil.produceToken(admin.getUsername()));
        return Response.newResponse().put("Code", 0).put("Message", "登录成功").setData(data);
    }
}
