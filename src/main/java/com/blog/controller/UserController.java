package com.blog.controller;

import com.blog.util.Response;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

/**
 * Created by 91383 on 2019/8/23.
 */
@CrossOrigin
@Controller
@ResponseBody
public class UserController {

    @RequestMapping(value = "/initAdd", method = RequestMethod.GET)
    public Response initInsert() throws Exception {
        HashMap map1= new HashMap();
        map1.put("suceess","11111111111");
        return Response.newResponse().ok(map1);
    }
}
