package cn.liuyiyou.boot.service;

import java.util.HashMap;
import java.util.Map;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author: liuyiyou.cn
 * @date: 2021/3/31
 * @version: V1.0
 */
@SpringBootTest
class RedisServiceTest {

    @Autowired
    private RedisService redisService;

    @Test
    void set() {
        final boolean set = redisService.set("mykey", "myvalue2", true);
        Assert.assertTrue(set);
        final boolean setEx = redisService.set("mykey", "myvalue2", false);
        Assert.assertFalse(setEx);
    }

    @Test
    void delKey() {
    }

    @Test
    void type() {
    }

    @Test
    void blpop() {
    }

    @Test
    void sadd() {
        redisService.sadd("user", "11", "12", "13", "14");
    }

    @Test
    void srem(){
        redisService.srem("user","13","14");
    }

    @Test
    void scard() {
        System.out.println(redisService.scard("user"));
    }

    @Test
    void hset() {
        redisService.hset("user:11", "_class", "cn.liuyiyou.boot.entity.User",false);
        redisService.hset("user:11", "id", "11",true);
        redisService.hset("user:11", "name", "lyy11",true);
    }

    @Test
    void hmset() {
        Map<String, String> user_12 = new HashMap<>();
        user_12.put("_class", "cn.liuyiyou.boot.entity.User");
        user_12.put("id", "12");
        user_12.put("name", "lyy12");
        redisService.hmset("user_12", user_12);
    }


    @Test
    void send(){
        redisService.publish("abc","def");
    }
}