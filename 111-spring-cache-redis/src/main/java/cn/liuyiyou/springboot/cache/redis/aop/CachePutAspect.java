package cn.liuyiyou.springboot.cache.redis.aop;

import cn.liuyiyou.springboot.cache.redis.annotation.PutCache;
import java.lang.reflect.Method;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 * @author: liuyiyou.cn
 * @date: 2020/6/19
 * @version: V1.0
 */
@Aspect
@Component
public class CachePutAspect {

  @Autowired
  private CacheManager cacheManager;

  @Autowired
  RedisTemplate<String, Object> redisTemplate;

  @Pointcut(value = "@annotation(cn.liuyiyou.springboot.cache.redis.annotation.PutCache)")
  public void pointcut() {
  }

  @Before(value = "pointcut()")
  public void before(JoinPoint joinPoint) throws NoSuchMethodException {
    MethodSignature signature = (MethodSignature) joinPoint.getSignature();
    Method method = joinPoint.getTarget().getClass()
        .getMethod(signature.getName(), signature.getMethod().getParameterTypes());
    PutCache cachePut = method.getAnnotation(PutCache.class);
    String key = cachePut.key();
    redisTemplate.delete(key);

  }

}
