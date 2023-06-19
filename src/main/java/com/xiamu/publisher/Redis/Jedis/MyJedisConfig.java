package com.xiamu.publisher.Redis.Jedis;


import redis.clients.jedis.Jedis;

public class MyJedisConfig {
   public Jedis getJedis(){
       Jedis jedis = new Jedis("127.0.0.1",6379);

       return jedis;
   }

    public static void main(String[] args) {
        MyJedisConfig myJedisConfig = new MyJedisConfig();
        myJedisConfig.getJedis().set("test2","test2");

        String test2 = myJedisConfig.getJedis().get("test2");
        System.out.println(test2);

    }
}
