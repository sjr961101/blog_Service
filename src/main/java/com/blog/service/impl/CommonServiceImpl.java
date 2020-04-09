package com.blog.service.impl;

import com.blog.dao.BlogConfigMapper;
import com.blog.dao.CommonMapper;
import com.blog.model.BlogConfig;
import com.blog.model.Common;
import com.blog.service.CommonService;
import com.blog.util.LogUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommonServiceImpl implements CommonService {
    @Autowired(required = false)
    CommonMapper commonMapper;

    @Autowired(required = false)
    BlogConfigMapper blogConfigMapper;

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

    @Override
    public BlogConfig blogInfo() {
        BlogConfig blogConfig=null;
        try{
            blogConfig=blogConfigMapper.selectConfig();
        }catch (Exception e){
            LogUtils.error(e);
            return null;
        }
        return blogConfig;
    }

    @Override
    public Integer modifyWebConfig(BlogConfig blogConfig) {
        int count=0;
        try{
            count = blogConfigMapper.modifyWebConfig(blogConfig);
        }catch (Exception e){
            LogUtils.error(e);
            return null;
        }
        return count;
    }
}
