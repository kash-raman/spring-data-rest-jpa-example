package com.prep.spring.data.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config2 {

    @Bean
    public String example(){
        return  new String("example2");
    }
}
