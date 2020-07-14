//package cn.liuyiyou.springboot.mycache.aop;
//
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.Around;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Pointcut;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.core.annotation.Order;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.stereotype.Component;
//
///**
// * @author: liuyiyou.cn
// * @date: 2020/7/14
// * @version: V1.0
// */
//@Aspect
//@Order(1)
//@Component
//public class CacheAspect {
//
//  @Autowired
//  RedisTemplate<String, Object> redisTemplate;
//
//  @Pointcut(value = "@annotation(Cache)")
//  private void getPointcut(Cache Cache) {
//
//  }
//
//
//  @Around("getPointcut(Cache)")
//  public Object preProcessQueryPattern(ProceedingJoinPoint point, Cache Cache) throws Throwable {
//    long startTime = System.currentTimeMillis();
//    String targetName = point.getTarget().getClass().getName();
//    String simpleName = point.getTarget().getClass().getSimpleName();
//    String methodName = point.getSignature().getName();
//    Object[] arguments = point.getArgs();
//    //重新加载 要更新的缓存方法名
//    if (Cache.reLoad()) {
//      methodName = Cache.method();
//    }
//    String key = null;
////        没传key
//    if (Cache.key().length() > 0) {
//      key = "'" + simpleName + "." + methodName + ".'+" + Cache.key();
//    } else {
//      key = simpleName + "." + methodName;
//    }
//
//    String[] paramNames = ParamNameMap.get(key);
//    if (paramNames == null) {
////          反射得到形参名称
//      paramNames = ReflectParamNames.getNames(targetName, methodName);
//      ParamNameMap.put(key, paramNames);
//    }
//    if (Cache.key().length() > 0) {
//      key = SpelParser.getKey(key, Cache.condition(), paramNames, arguments);
//    }
//    if (key.length() > 200) {
//    }
//    Object object = null;
////      重新加载时不走缓存
//    if (!Cache.reLoad()) {
//      object = redisTemplate.opsForValue().get(key);
//    }
//    long endTime = System.currentTimeMillis();
//    if (object != null) {
//      long t = endTime - startTime;
//      return object;
//    }
//    Object target = point.proceed();
//    if (target != null) {
//      redisTemplate.opsForValue().set(key, target, Cache.second());
//      endTime = System.currentTimeMillis();
//    }
//    //拦截的放参数类型
////       Class[] parameterTypes = ((MethodSignature)point.getSignature()).getMethod().getParameterTypes();
//    return target;
//  }
//}
