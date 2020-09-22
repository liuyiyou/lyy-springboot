package cn.liuyiyou.springboot.autoconfigure.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 * @author: liuyiyou.cn
 * @date: 2020/8/19
 * @version: V1.0
 */
@Component("redisService")
public class RedisService {

    @Autowired
    private KeyGenerator simpleKeyGenerator;

    @Autowired
    RedisTemplate<String, Object> redisTemplate;

    public void set(String key, String value) {
        redisTemplate.opsForValue().set(key, value);
    }

    public String get(String key) {
        return redisTemplate.opsForValue().get(key).toString();
    }
}
