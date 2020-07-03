package cn.liuyiyou.springboot.mycache.aop;

import cn.liuyiyou.springboot.mycache.annotation.CachePrefix;
import cn.liuyiyou.springboot.mycache.annotation.PutCache;
import java.lang.reflect.Method;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * @author: liuyiyou.cn
 * @date: 2020/6/19
 * @version: V1.0
 */
@Aspect
@Component
public class PutCacheAspect {

  @Autowired
  private KeyGenerator simpleKeyGenerator;

  @Autowired
  RedisTemplate<String, Object> redisTemplate;

  @Pointcut(value = "@annotation(cn.liuyiyou.springboot.mycache.annotation.PutCache)")
  public void pointcut() {
  }

  @Around(value = "pointcut()")
  public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
    MethodSignature signature = (MethodSignature) joinPoint.getSignature();
    Method method = joinPoint.getTarget().getClass()
        .getMethod(signature.getName(), signature.getMethod().getParameterTypes());
    CachePrefix cachePrefix = method.getDeclaringClass().getAnnotation(CachePrefix.class);
    if (cachePrefix == null) {
      throw new RuntimeException("@PutCache注解的方法必须要在所在类上加@CachePrefix");
    }
    PutCache cachePut = method.getAnnotation(PutCache.class);
    String key = cachePut.key();
    if (StringUtils.isEmpty(key)) {
      key = cachePrefix.classPrefix() + simpleKeyGenerator
          .generate(joinPoint.getTarget(), method, joinPoint.getArgs()).toString();
    }
    redisTemplate.delete(key);
    if (redisTemplate.opsForValue().get(key) != null) {
      return redisTemplate.opsForValue().get(key);
    } else {
      final Object proceed = joinPoint.proceed();
      redisTemplate.opsForValue().set(key, proceed);
      return proceed;
    }

  }

}
