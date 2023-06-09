package com.xiamu.publisher;

import org.springframework.context.annotation.Bean;

public class AppConfig {
   @Bean
    public MyBean myBean(){
        return  new MyBean();
    }
    public class MyBean{
        public MyBean(){
            System.out.println("MyBean Initializing");
        }
    }
}
