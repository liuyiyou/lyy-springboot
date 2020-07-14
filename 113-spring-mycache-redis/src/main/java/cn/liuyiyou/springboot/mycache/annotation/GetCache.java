package cn.liuyiyou.springboot.mycache.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.persistence.Cacheable;
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
//@Cacheable
public @interface GetCache {

//  @AliasFor(annotation = Cacheable.class)
  String key() default "";

  int second() default 60 * 60; //秒

//  @AliasFor("cacheNames")
//  String keyPrefix() default "";
}
