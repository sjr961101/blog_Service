package com.blog.center.service;


import com.blog.tool.model.BlogConfig;
import com.blog.tool.model.Common;

public interface CommonService {
    Common statistic();

    BlogConfig blogInfo();
}
