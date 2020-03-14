package com.blog.center.config;


import org.springframework.context.annotation.Bean;
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
