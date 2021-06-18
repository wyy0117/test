package com.wyy.cachetest;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
class RedisUtilTest {

    @Autowired
    private RedisUtil redisUtil;

    @Test
   public void setIfAbsentTest() {
        String key = "vote:lock:123123123";
        String value = "456";
        boolean absent = redisUtil.setIfAbsent(key, value);
        System.out.println("absent = " + absent);

        absent = redisUtil.setIfAbsent(key, value);
        System.out.println("absent = " + absent);

        redisUtil.delete(key);

        absent = redisUtil.setIfAbsent(key, value);
        System.out.println("absent = " + absent);

        redisUtil.delete(key);
    }
}
