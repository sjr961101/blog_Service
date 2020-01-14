package com.blog.interceptor;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

//@Configuration
public class InterceptorConfig extends WebMvcConfigurationSupport {
    @Bean
    public InterfaceAuthTokenInterceptor getInterfaceAuthTokenInterceptor(){
        return new InterfaceAuthTokenInterceptor();
    }

//    @Override
//    protected void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(getInterfaceAuthTokenInterceptor()).addPathPatterns("/a/**");
//        super.addInterceptors(registry);
//    }
}
