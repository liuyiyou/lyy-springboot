package cn.liuyiyou.springboot.mycache.aop;

import cn.liuyiyou.springboot.mycache.annotation.CachePrefix;
import cn.liuyiyou.springboot.mycache.annotation.PostCache;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
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
public class PostCacheAspect {

  @Autowired
  private KeyGenerator simpleKeyGenerator;

  @Autowired
  RedisTemplate<String, Object> redisTemplate;

  @Pointcut(value = "@annotation(cn.liuyiyou.springboot.mycache.annotation.PostCache)")
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
    PostCache postCache = method.getAnnotation(PostCache.class);
    String key = postCache.key();
    if (StringUtils.isEmpty(key)) {
      throw new RuntimeException("新增方法必须指定主键key");
    }
    Object proceed = joinPoint.proceed();
    String s = JSON.toJSONString(proceed);
    String keyValue = JSONObject.parseObject(s).getString(key);
    redisTemplate.opsForValue().set(cachePrefix.classPrefix() + keyValue, proceed);
    return proceed;
  }

}
