package com.prep.spring.data.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Import;
@SpringBootApplication
@Import({Config1.class,Config2.class})
public class TestApp {
    public static void main(String [] arg){
       ApplicationContext applicationContext= SpringApplication.run(TestApp.class);
        System.out.println("id" +applicationContext.getBean("example"));

    }
}

