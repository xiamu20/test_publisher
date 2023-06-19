package com.xiamu.publisher.Redis.Jedis;

public class Test {
    public static void main(String[] args) {
        MyJedisConfig myJedisConfig = new MyJedisConfig();
        myJedisConfig.getJedis().set("test2","test2");

        String test2 = myJedisConfig.getJedis().get("test2");
        System.out.println(test2);

    }
}
