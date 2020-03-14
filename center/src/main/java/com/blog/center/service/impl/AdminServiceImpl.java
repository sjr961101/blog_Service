package com.blog.center.service.impl;


import com.blog.center.service.AdminService;
import com.blog.tool.model.Admin;
import com.blog.tool.utils.PathUtil;
import com.blog.tool.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    RestTemplate restTemplate;

    public Response Login(Admin admin){
        return restTemplate.postForObject(PathUtil.systemDomain,admin,Response.class);
    }
}
