package cn.liuyiyou.springboot.app;

import java.time.Duration;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
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
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
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
public class CustomerRedisConfig  {

  @Bean(name = "customerRedisTemplate")
  public RedisTemplate<String, Object> customerRedisTemplate(
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


  private RedisSerializer<String> keySerializer() {
    return new StringRedisSerializer();
  }

  private RedisSerializer<Object> valueSerializer() {
    return new JdkSerializationRedisSerializer();
  }
}
