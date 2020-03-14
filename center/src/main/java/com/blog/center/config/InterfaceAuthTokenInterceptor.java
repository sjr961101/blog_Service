package com.blog.center.config;

import com.blog.tool.utils.RedisUtil;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InterfaceAuthTokenInterceptor implements HandlerInterceptor {
    @Resource
    RedisUtil redisUtil;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token=request.getParameter("token");
        if(token == null  ||  token.equals("")){
            response.setContentType("application/json;charset=utf-8");
            String re="{'code':'-4001','message':'登录失效'}";
            response.getWriter().write(re);
            return false;
        }else{
            String localToken=redisUtil.get(token);
        }
        return true;
    }
}
