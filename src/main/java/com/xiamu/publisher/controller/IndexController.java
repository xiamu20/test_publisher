package com.xiamu.publisher.controller;

import org.redisson.Redisson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class IndexController {
    @Autowired
    ConfigurableEnvironment environment;
    @Autowired
    Redisson redisson;

     int stock=200;

    @RequestMapping("/deduct_stock")
    public String deductStock() {
        if (stock > 0) {
            int realStock = stock - 1;
            String name = "applicationConfig: [classpath:/application-dynamic.yml]";
            MapPropertySource propertySource = (MapPropertySource) environment.getPropertySources().get(name);
            Map<String, Object> source = propertySource.getSource();
            Map<String, Object> map = new HashMap<>(source.size());
            map.putAll(source);

            environment.getPropertySources().replace(name, new MapPropertySource(name, map));

        }

        return "";
    }
}


