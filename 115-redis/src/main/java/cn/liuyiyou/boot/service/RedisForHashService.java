package cn.liuyiyou.boot.service;

import cn.liuyiyou.boot.entity.User;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.hash.HashMapper;
import org.springframework.data.redis.hash.ObjectHashMapper;

/**
 * @author: liuyiyou.cn
 * @date: 2021/3/20
 * @version: V1.0
 */
public class RedisForHashService {


    @Autowired
    HashOperations<String,byte[],byte[]> hashOperations;
    HashMapper<Object,byte[],byte[]> mapper = new ObjectHashMapper();

    public void writeHash(String key, User user){
        Map<byte[],byte[]> mappeedHash = mapper.toHash(user);
        hashOperations.putAll(key,mappeedHash);
    }

}
