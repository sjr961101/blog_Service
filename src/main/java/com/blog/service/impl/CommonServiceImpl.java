package com.blog.service.impl;

import com.blog.dao.CommonMapper;
import com.blog.model.Common;
import com.blog.service.CommonService;
import com.blog.util.LogUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommonServiceImpl implements CommonService {
    @Autowired(required = false)
    CommonMapper commonMapper;

    @Override
    public Common statistic() {
        Common common=null;
        try{
            common=commonMapper.statistics();
        }catch (Exception e){
            LogUtils.error(e);
            return null;
        }
        return common;
    }
}
