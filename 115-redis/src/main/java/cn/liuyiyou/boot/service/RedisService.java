package cn.liuyiyou.boot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.DataType;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/**
 * @author: liuyiyou.cn
 * @date: 2021/3/20
 * @version: V1.0
 */
@Service
public class RedisService {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;



    public boolean delKey(String key) {
        return redisTemplate.delete(key);
    }

    public DataType type(String key) {
        return redisTemplate.type(key);
    }

    public String blpop(String key) {
        final ListOperations<String, String> stringStringListOperations = redisTemplate.opsForList();
        final String s = stringStringListOperations.leftPop(key);
        return s;
    }
}
