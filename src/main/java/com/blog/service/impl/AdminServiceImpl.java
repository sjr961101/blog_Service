package com.blog.service.impl;

import com.blog.dao.AdminMapper;
import com.blog.pojo.Admin;
import com.blog.pojo.AdminKey;
import com.blog.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired(required = false)
    AdminMapper adminMapper;


    @Override
    public Admin selectByName(Admin name) {
        Admin admin=null;
        try {
            admin = adminMapper.selectByName(name);
        }catch (Exception e){
            e.printStackTrace();
        }
        return admin;
    }
}
