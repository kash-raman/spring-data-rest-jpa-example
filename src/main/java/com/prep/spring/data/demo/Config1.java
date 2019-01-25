package com.prep.spring.data.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config1 {

    @Bean
    public String example(){
        return  new String("example1");
    }
}
