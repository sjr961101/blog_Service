package com.blog.center;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableTransactionManagement
@ComponentScan(value="com.blog")
public class CenterApplication {

    public static void main(String[] args) {

        SpringApplication.run(CenterApplication.class, args);
    }

    @Bean
    public RestTemplate getRestTemple(){
        return new RestTemplate();
    }
}
