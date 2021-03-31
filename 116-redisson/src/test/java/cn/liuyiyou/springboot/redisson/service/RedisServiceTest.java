package cn.liuyiyou.springboot.redisson.service;

import static org.junit.jupiter.api.Assertions.*;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author: liuyiyou.cn
 * @date: 2021/3/29
 * @version: V1.0
 */
@SpringBootTest
@Slf4j
class RedisServiceTest {

    @Autowired
    private RedisService redisService;

    @Test
    void lock() {
    }

    @Test
    void set() {
        final String set = redisService.set("mykey", "abc");
    }

    @Test
    void setNx() {
        redisService.set("mykey","bcd");
    }
}