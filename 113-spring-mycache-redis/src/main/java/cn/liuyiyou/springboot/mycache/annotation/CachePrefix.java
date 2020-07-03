package cn.liuyiyou.springboot.mycache.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author: liuyiyou.cn
 * @date: 2020/7/3
 * @version: V1.0
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface CachePrefix {

  String classPrefix() default "";
}
