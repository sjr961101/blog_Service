package com.blog.service;

import com.blog.model.BlogConfig;
import com.blog.model.Common;

public interface CommonService {
    Common statistic();

    BlogConfig blogInfo();
}
