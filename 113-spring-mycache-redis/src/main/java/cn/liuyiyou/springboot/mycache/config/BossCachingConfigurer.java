//package cn.liuyiyou.springboot.mycache.config;
//
//import cn.hutool.json.JSONUtil;
//import java.util.HashMap;
//import java.util.Map;
//import org.apache.commons.codec.digest.DigestUtils;
//import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
//import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
//import org.springframework.boot.context.properties.EnableConfigurationProperties;
//import org.springframework.cache.annotation.CachingConfigurerSupport;
//import org.springframework.cache.annotation.EnableCaching;
//import org.springframework.cache.interceptor.KeyGenerator;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.redis.core.RedisOperations;
//import org.springframework.stereotype.Component;
//
///**
// * @author: liuyiyou.cn
// * @date: 2020/7/2
// * @version: V1.0
// */
//@Component
//@EnableCaching
//@ConditionalOnClass(RedisOperations.class)
//@EnableConfigurationProperties(RedisProperties.class)
//public class BossCachingConfigurer extends CachingConfigurerSupport {
//
//  /**
//   * 自定义缓存key生成策略，默认将使用该策略
//   */
//  @Bean
//  @Override
//  public KeyGenerator keyGenerator() {
//    return (target, method, params) -> {
//      Map<String,Object> container = new HashMap<>(3);
//      Class<?> targetClassClass = target.getClass();
//      // 类地址
//      container.put("class",targetClassClass.toGenericString());
//      // 方法名称
//      container.put("methodName",method.getName());
//      // 包名称
//      container.put("package",targetClassClass.getPackage());
//      // 参数列表
//      for (int i = 0; i < params.length; i++) {
//        container.put(String.valueOf(i),params[i]);
//      }
//      // 转为JSON字符串
//      String jsonString = JSONUtil.toJsonStr(container);
//      // 做SHA256 Hash计算，得到一个SHA256摘要作为Key
//      return DigestUtils.sha256Hex(jsonString);
//    };
//  }
//}
