package cn.liuyiyou.springboot.cache.redis.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.core.annotation.AliasFor;

/**
 * 洋老板缓存
 *
 * @author: liuyiyou.cn
 * @date: 2020/7/2
 * @version: V1.0
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
@Cacheable
public @interface GetCache {

  @AliasFor(annotation = Cacheable.class)
  String key() default "";
}
