package com.blog.service;

import com.blog.pojo.Admin;
import com.blog.pojo.AdminKey;

public interface AdminService {
    Admin selectByName(Admin name);
}
