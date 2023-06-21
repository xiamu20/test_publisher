package com.xiamu.publisher.redis.redisson;

import org.redisson.Redisson;
import org.redisson.config.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyRedissonConfig {
    @Bean
   public Redisson redisson(){
        Config config = new Config();
       // config.useClusterServers()
        config.useSingleServer().setAddress("redis://127.0.0.1:6379");

        Redisson redisson = (Redisson) Redisson.create(config);
        return redisson;
    }

}
