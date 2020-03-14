package com.blog.system.service.impl;


import com.blog.system.dao.AdminMapper;
import com.blog.system.service.AdminService;
import com.blog.tool.model.Admin;
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
