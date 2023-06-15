package com.xiamu.publisher;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableScheduling
@EnableAutoConfiguration
@RestController
@SpringBootApplication
@MapperScan(basePackages = "com.xiamu.publisher.mapper")
public class App {
    public static void main(String[] args) {

        SpringApplication.run(App.class,args);

    }
    @GetMapping("test")
    public String hello() {
        return "hello";
    }

}
