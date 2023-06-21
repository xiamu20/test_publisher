package com.xiamu.publisher.redis.redisson;

import org.redisson.api.RBucket;

import java.util.concurrent.TimeUnit;

public class Test {

    public static void main(String[] args) {
        String redisKey="redisKey";
        MyRedissonConfig myRedissonConfig = new MyRedissonConfig();
        RBucket<Object> bucket = myRedissonConfig.redisson().getBucket(redisKey);
        Object o = bucket.get();
        System.out.println("0:"+o);
        bucket.set(1,10, TimeUnit.SECONDS);
    }



}

