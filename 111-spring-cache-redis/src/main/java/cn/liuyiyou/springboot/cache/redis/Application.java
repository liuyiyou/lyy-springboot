package cn.liuyiyou.springboot.cache.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableCaching
@RestController
@EnableAspectJAutoProxy
public class Application {

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }

//
//  @Bean
//  public CacheManager cacheManager(RedisConnectionFactory redisConnectionFactory) {
//    return RedisCacheManager.RedisCacheManagerBuilder
//        .fromConnectionFactory(redisConnectionFactory).build();
//  }


  @Autowired
  private RedisTemplate<String, String> stringRedisTemplate;

  @GetMapping("/")
  public String home() {
    stringRedisTemplate.opsForValue().set("username", "lyy");
    return stringRedisTemplate.opsForValue().get("username");
  }


}
