package com.xiamu.publisher;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BeanAppTest {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        context.getBean("myBean");
    }
}
