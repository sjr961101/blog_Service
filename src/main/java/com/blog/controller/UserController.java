package com.blog.controller;

import com.blog.util.RedisUtil;
import com.blog.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by 91383 on 2019/8/23.
 */
@CrossOrigin
@Controller
@ResponseBody
public class UserController {
    @Resource
    private RedisUtil redisUtil;

    @RequestMapping(value = "/testRedis", method = RequestMethod.GET)
    public Response initInsert() throws Exception {
        Map map1= new HashMap();
        redisUtil.set("code","200");
        String value = redisUtil.get("code");
        System.out.println(value);
        map1.put("suceess","11111111111");
        return Response.newResponse().ok(map1);
    }
}
