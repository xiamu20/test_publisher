package com.xiamu.publisher.Redis.Jedis;


import redis.clients.jedis.Jedis;

public class MyJedisConfig {
   public Jedis getJedis(){
       Jedis jedis = new Jedis("127.0.0.1",6379);

       return jedis;
   }


}
