package cn.liuyiyou.springboot.redisson;

import java.util.HashMap;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.redisson.api.RBucket;
import org.redisson.api.RBuckets;
import org.redisson.api.RKeys;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;

@SpringBootTest
@Slf4j
class ApplicationTests {

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Autowired
    RedissonClient redissonClient;

    @Test
    void contextLoads() {
        RBucket<String> mykey = redissonClient.getBucket("key");
        log.info("keyValue:{}", mykey.get());
        mykey.set("value");
        log.info("keyValue:{}", mykey.get());
    }

    void list() {
        final RBuckets buckets = redissonClient.getBuckets();
        Map<String, String> loadedBuckets = buckets.get("myBucket1", "myBucket2", "myBucket3");
    }

    @Test
    void hash() {
        final RKeys keys = redissonClient.getKeys();
        final long count = keys.count();
        keys.getKeys().forEach(System.out::println);
        log.info("count::{}", count);
    }

}
