package cn.liuyiyou.springboot.cache.redis;

import cn.hutool.json.JSON;
import cn.hutool.json.JSONUtil;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * @author: liuyiyou.cn
 * @date: 2020/5/12
 * @version: V1.0
 */
@Slf4j
@Configuration
@EnableCaching
@ConditionalOnClass(RedisOperations.class)
@EnableConfigurationProperties(RedisProperties.class)
public class RedisConfig extends CachingConfigurerSupport {

  @Bean(name = "redisTemplate")
  @ConditionalOnMissingBean(name = "redisTemplate")
  public RedisTemplate<String, Object> redisTemplate(
      RedisConnectionFactory redisConnectionFactory) {
    RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
    redisTemplate.setConnectionFactory(redisConnectionFactory);
    redisTemplate.setKeySerializer(keySerializer());
    redisTemplate.setHashKeySerializer(keySerializer());
    redisTemplate.setValueSerializer(valueSerializer());
    redisTemplate.setHashValueSerializer(valueSerializer());
    return redisTemplate;
  }

  @Primary
  @Bean
  public CacheManager cacheManager(RedisConnectionFactory redisConnectionFactory) {
    //缓存配置对象
    RedisCacheConfiguration redisCacheConfiguration = RedisCacheConfiguration.defaultCacheConfig();

    redisCacheConfiguration = redisCacheConfiguration
        .entryTtl(Duration.ofMinutes(30L)) //设置缓存的默认超时时间：30分钟
        .disableCachingNullValues()             //如果是空值，不缓存
        .serializeKeysWith(RedisSerializationContext.SerializationPair
            .fromSerializer(keySerializer()))         //设置key序列化器
        .serializeValuesWith(RedisSerializationContext.SerializationPair
            .fromSerializer((valueSerializer())));  //设置value序列化器

    return RedisCacheManager
        .builder(RedisCacheWriter.nonLockingRedisCacheWriter(redisConnectionFactory))
        .cacheDefaults(redisCacheConfiguration).build();
  }

  /**
   * 自定义缓存key生成策略，默认将使用该策略
   */
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

  private RedisSerializer<String> keySerializer() {
    return new StringRedisSerializer();
  }

  private RedisSerializer<Object> valueSerializer() {
    return new GenericJackson2JsonRedisSerializer();
  }
}
