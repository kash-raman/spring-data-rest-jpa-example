package com.prep.spring.data.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(value = "com.techprimers")
public class AppConfig {
    private String test;

    public AppConfig(@Value("${server.port}") String test) {
        this.test = test;
    }
}
