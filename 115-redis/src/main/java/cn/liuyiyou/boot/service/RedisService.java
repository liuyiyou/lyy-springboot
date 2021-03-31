package cn.liuyiyou.boot.service;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.DataType;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisCallback;
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

    //String 相关命令


    public boolean set(String key, String value, boolean isOverwrite) {
        if (isOverwrite) {
            return redisTemplate.execute((RedisCallback<Boolean>) connection -> connection.stringCommands().set(key.getBytes(), value.getBytes()));
        } else {
            return redisTemplate.execute((RedisCallback<Boolean>) connection -> connection.stringCommands().setNX(key.getBytes(), value.getBytes()));
        }

    }


    public boolean setEx(String key, String value) {
        return redisTemplate.execute((RedisCallback<Boolean>) connection -> connection.stringCommands().setEx(key.getBytes(), 100L, value.getBytes()));
    }

    //集合相关命令
    public void sadd(String key, String... value) {
        final Long add = redisTemplate.opsForSet().add(key, value);
    }

    public Long scard(String key) {
        return redisTemplate.opsForSet().size(key);
    }

    public void srem(String key, String... value) {
        redisTemplate.opsForSet().remove(key, value);
    }

    //Hash相关命令
    public void hset(String key, String filed, String value, boolean overwrite) {
        if (overwrite) {
            redisTemplate.opsForHash().put(key, filed, value);
        } else {
            redisTemplate.opsForHash().putIfAbsent(key, filed, value);
        }

    }

    public void hmset(String key, Map<String, String> maps) {
        redisTemplate.opsForHash().putAll(key, maps);
    }


    //pub/sub
    public void publish(String channel, String msg) {
        redisTemplate.convertAndSend(channel, msg);
    }



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
