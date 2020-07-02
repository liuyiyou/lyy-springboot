//package cn.liuyiyou.springboot.mycache.aop;
//
//import java.lang.reflect.Method;
//import org.aspectj.lang.JoinPoint;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Before;
//import org.aspectj.lang.annotation.Pointcut;
//import org.aspectj.lang.reflect.MethodSignature;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.cache.annotation.CachePut;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.stereotype.Component;
//
///**
// * @author: liuyiyou.cn
// * @date: 2020/6/19
// * @version: V1.0
// */
//@Aspect
//@Component
//public class UpdateAspect {
//
//  @Autowired
//  RedisTemplate<String, Object> redisTemplate;
//
//  @Pointcut(value = "@annotation(org.springframework.cache.annotation.CachePut)")
//  public void pointcut() {
//  }
//
//  @Before(value = "pointcut()")
//  public void before(JoinPoint joinPoint) throws NoSuchMethodException {
//    MethodSignature signature = (MethodSignature) joinPoint.getSignature();
//    Method method = joinPoint.getTarget().getClass()
//        .getMethod(signature.getName(), signature.getMethod().getParameterTypes());
//    CachePut cachePut = method.getAnnotation(CachePut.class);
//    String key = cachePut.key();
//    redisTemplate.delete(key);
//
//  }
//
//}
