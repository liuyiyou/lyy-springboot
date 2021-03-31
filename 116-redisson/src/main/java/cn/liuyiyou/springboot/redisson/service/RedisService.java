package cn.liuyiyou.springboot.redisson.service;

import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RBucket;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: liuyiyou.cn
 * @date: 2021/3/29
 * @version: V1.0
 */
@Service
@Slf4j
public class RedisService {

    @Autowired
    private RedissonClient redissonClient;


    public void lock(String lockKey) {
        final RLock lock = redissonClient.getLock(lockKey);
        try{
            lock.lock();
        }catch (Exception e){
            log.error("分布式锁加锁异常",e);
        }finally {
            lock.unlock();;
        }
    }

    public <T> T set(String key, T value) {
        final RBucket<T> bucket = redissonClient.getBucket(key);
        return bucket.getAndSet(value);

    }

    public <T> boolean setNx(String key, T value) {
        final RBucket<T> bucket = redissonClient.getBucket(key);
        return bucket.setIfExists(value);
    }

}
