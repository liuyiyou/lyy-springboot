package cn.liuyiyou.springboot.cache.redis.aop;

import cn.liuyiyou.springboot.cache.redis.annotation.GetCache;
import java.lang.reflect.Method;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.common.TemplateParserContext;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * @author: liuyiyou.cn
 * @date: 2020/6/19
 * @version: V1.0
 */
@Aspect
@Component
public class CacheGetAspect {

  @Autowired
  private KeyGenerator keyGenerator;

  @Autowired
  RedisTemplate<String, Object> redisTemplate;

  @Pointcut(value = "@annotation(cn.liuyiyou.springboot.cache.redis.annotation.GetCache)")
  public void pointcut() {
  }

  @Around(value = "pointcut()")
  public Object before(ProceedingJoinPoint joinPoint) throws Throwable {
    MethodSignature signature = (MethodSignature) joinPoint.getSignature();
    Method method = joinPoint.getTarget().getClass()
        .getMethod(signature.getName(), signature.getMethod().getParameterTypes());
    GetCache cachePut = method.getAnnotation(GetCache.class);
    String key = cachePut.key();
    ExpressionParser parser = new SpelExpressionParser();
    Expression expression = parser.parseExpression(key, new TemplateParserContext());
    EvaluationContext context = new StandardEvaluationContext();
    if(StringUtils.isEmpty(expression.getValue(context))){
       key = keyGenerator
          .generate(joinPoint.getTarget(), method, joinPoint.getArgs()).toString();
    }
    if(redisTemplate.opsForValue().get(key)!=null){
      return redisTemplate.opsForValue().get(key);
    }else{
      final Object proceed = joinPoint.proceed();
      redisTemplate.opsForValue().set(key,proceed);
      return proceed;
    }
  }

}
