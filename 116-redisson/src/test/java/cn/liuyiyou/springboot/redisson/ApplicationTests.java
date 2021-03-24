package cn.liuyiyou.springboot.redisson;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.redisson.api.RBucket;
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
        log.info("keyValue:{}",mykey.get());
        mykey.set("value");
        log.info("keyValue:{}",mykey.get());
        final RKeys keys = redissonClient.getKeys();
        final long count = keys.count();
        log.info("count::{}",count);
    }

}
