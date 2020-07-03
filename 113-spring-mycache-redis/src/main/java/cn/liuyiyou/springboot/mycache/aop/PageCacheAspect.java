package cn.liuyiyou.springboot.mycache.aop;

import cn.liuyiyou.springboot.mycache.annotation.CachePrefix;
import cn.liuyiyou.springboot.mycache.annotation.PageCache;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import java.lang.reflect.Method;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * @author: liuyiyou.cn
 * @date: 2020/6/19
 * @version: V1.0
 */
@Aspect
@Component
public class PageCacheAspect {

  @Autowired
  private KeyGenerator keyGenerator;

  @Autowired
  RedisTemplate<String, Object> redisTemplate;

  @Pointcut(value = "@annotation(cn.liuyiyou.springboot.mycache.annotation.PageCache)")
  public void pointcut() {
  }

  @Around(value = "pointcut()")
  public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
    MethodSignature signature = (MethodSignature) joinPoint.getSignature();
    Method method = joinPoint.getTarget().getClass()
        .getMethod(signature.getName(), signature.getMethod().getParameterTypes());
    CachePrefix cachePrefix = method.getDeclaringClass().getAnnotation(CachePrefix.class);
    if(cachePrefix==null){
      throw new RuntimeException("@PageCache注解的方法必须要在所在类上加@CachePrefix");
    }
    PageCache pageCache = method.getAnnotation(PageCache.class);
    String classPrefix = cachePrefix.classPrefix();
    String keyPrefix = pageCache.keyPrefix();
    if (StringUtils.isEmpty(keyPrefix) && StringUtils.isEmpty(classPrefix)) {
      throw new RuntimeException("@CachePrefix和@PageCache的prefix不能同时为空");
    }
    String key = classPrefix + ":" + keyPrefix + keyGenerator
        .generate(joinPoint.getTarget(), method, joinPoint.getArgs()).toString();
    if (redisTemplate.opsForValue().get(key) != null) {
      return redisTemplate.opsForValue().get(key);
    } else {
      final Object proceed = joinPoint.proceed();
      redisTemplate.opsForValue().set(key, proceed);
      return proceed;
    }
  }

  private RedisSerializer<Object> valueSerializer() {
    ObjectMapper mapper = new ObjectMapper();
    //序列化的时候序列对象的所有属性
    mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
    mapper.registerModule(new JavaTimeModule());
    return new GenericJackson2JsonRedisSerializer(mapper);
  }

}
