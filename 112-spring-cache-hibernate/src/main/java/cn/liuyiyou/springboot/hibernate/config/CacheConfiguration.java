package cn.liuyiyou.springboot.hibernate.config;

import cn.liuyiyou.springboot.hibernate.entity.Brand;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import javax.cache.configuration.MutableConfiguration;
import javax.cache.expiry.CreatedExpiryPolicy;
import org.hibernate.cache.jcache.ConfigSettings;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.redisson.config.SingleServerConfig;
import org.redisson.jcache.configuration.RedissonConfiguration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.cache.JCacheManagerCustomizer;
import org.springframework.boot.autoconfigure.orm.jpa.HibernatePropertiesCustomizer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: liuyiyou.cn
 * @date: 2020/6/19
 * @version: V1.0
 */
@Configuration
@EnableCaching
public class CacheConfiguration {

  @Value("${spring.redis.password}")
  private String password;

  @Value("${spring.redis.server")
  private String redisServer;

  private static RedissonClient redissonClient;
  @Bean
  public javax.cache.configuration.Configuration<Object, Object> jcacheConfiguration() {
    MutableConfiguration<Object, Object> jcacheConfig = new MutableConfiguration<>();
    Config config = new Config();

    SingleServerConfig singleServerConfig = config.useSingleServer();
    singleServerConfig.setAddress(redisServer);
    jcacheConfig.setStatisticsEnabled(true);
    redissonClient = Redisson.create(config);
    return RedissonConfiguration.fromInstance(redissonClient, jcacheConfig);
  }

  @Bean
  public HibernatePropertiesCustomizer hibernatePropertiesCustomizer(javax.cache.CacheManager cm) {
    return hibernateProperties -> hibernateProperties.put(ConfigSettings.CACHE_MANAGER, cm);
  }

  @Bean
  public JCacheManagerCustomizer cacheManagerCustomizer(javax.cache.configuration.Configuration<Object, Object> jcacheConfiguration) {
    return cm -> {
      // jhipster-needle-redis-add-entry
      createCache(cm, Brand.class.getName(), jcacheConfiguration);
    };
  }

  private void createCache(javax.cache.CacheManager cm, String cacheName, javax.cache.configuration.Configuration<Object, Object> jcacheConfiguration) {
    javax.cache.Cache<Object, Object> cache = cm.getCache(cacheName);
    if (cache != null) {
      cm.destroyCache(cacheName);
    }
    cm.createCache(cacheName, jcacheConfiguration);
  }

  public static RedissonClient getRedissonClient() {
    return redissonClient;
  }
}
