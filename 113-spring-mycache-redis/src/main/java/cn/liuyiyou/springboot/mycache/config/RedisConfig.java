package cn.liuyiyou.springboot.mycache.config;

import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.cache.interceptor.SimpleKey;
import org.springframework.cache.interceptor.SimpleKeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
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
  public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
    RedisTemplate<String, Object> template = new RedisTemplate<>();
    //序列化
    FastJsonRedisSerializer<Object> fastJsonRedisSerializer = new FastJsonRedisSerializer<>(Object.class);
    // value值的序列化采用fastJsonRedisSerializer
    template.setValueSerializer(fastJsonRedisSerializer);
    template.setHashValueSerializer(fastJsonRedisSerializer);
    // 全局开启AutoType，这里方便开发，使用全局的方式
    ParserConfig.getGlobalInstance().setAutoTypeSupport(true);
    // 建议使用这种方式，小范围指定白名单
    // ParserConfig.getGlobalInstance().addAccept("me.zhengjie.domain");
    // key的序列化采用StringRedisSerializer
    template.setKeySerializer(new StringRedisSerializer());
    template.setHashKeySerializer(new StringRedisSerializer());
    template.setConnectionFactory(redisConnectionFactory);
    return template;
  }

  @Bean
  public RedisCacheConfiguration redisCacheConfiguration(){
    FastJsonRedisSerializer<Object> fastJsonRedisSerializer = new FastJsonRedisSerializer<>(Object.class);
    RedisCacheConfiguration configuration = RedisCacheConfiguration.defaultCacheConfig();
    configuration = configuration.serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(fastJsonRedisSerializer)).entryTtl(Duration.ofHours(2));
    return configuration;
  }

//  @Primary
//  @Bean
//  public CacheManager cacheManager(RedisConnectionFactory redisConnectionFactory) {
//    //缓存配置对象
//    // 全局开启AutoType，这里方便开发，使用全局的方式
//    ParserConfig.getGlobalInstance().setAutoTypeSupport(true);
//    RedisCacheConfiguration redisCacheConfiguration = RedisCacheConfiguration.defaultCacheConfig();
//    FastJsonRedisSerializer<Object> fastJsonRedisSerializer = new FastJsonRedisSerializer<>(Object.class);
//    redisCacheConfiguration = redisCacheConfiguration
//        .entryTtl(Duration.ofMinutes(30L)) //设置缓存的默认超时时间：30分钟
//        .disableCachingNullValues()             //如果是空值，不缓存
//        .serializeKeysWith(RedisSerializationContext.SerializationPair
//            .fromSerializer(keySerializer()))         //设置key序列化器
//        .serializeValuesWith(RedisSerializationContext.SerializationPair
//            .fromSerializer((fastJsonRedisSerializer)))//设置value序列化器
//    ;
//    return RedisCacheManager
//        .builder(RedisCacheWriter.nonLockingRedisCacheWriter(redisConnectionFactory))
//        .cacheDefaults(redisCacheConfiguration).build();
//  }


//  @Override
  @Bean("simpleKeyGenerator")
  public KeyGenerator simpleKeyGenerator() {
    return new SimpleKeyGenerator();
//    return (target, method, params) -> {
//      if (params.length == 0) {
//        return SimpleKey.EMPTY;
//      }
//      if (params.length == 1) {
//        Object param = params[0];
//        if (param != null && !param.getClass().isArray()) {
//          return param;
//        }
//      }
//      return new SimpleKey(params);
//    };
  }

  /**
   * 自定义缓存key生成策略，默认将使用该策略
   */
  @Bean
  @Override
  public KeyGenerator keyGenerator() {
    return (target, method, params) -> {
      Map<String,Object> container = new HashMap<>(3);
      Class<?> targetClassClass = target.getClass();
      // 类地址
      container.put("class",targetClassClass.toGenericString());
      // 方法名称
      container.put("methodName",method.getName());
      // 包名称
      container.put("package",targetClassClass.getPackage());
      // 参数列表
      for (int i = 0; i < params.length; i++) {
        container.put(String.valueOf(i),params[i]);
      }
      // 转为JSON字符串
      String jsonString = JSONUtil.toJsonStr(container);
      // 做SHA256 Hash计算，得到一个SHA256摘要作为Key
      return DigestUtils.sha256Hex(jsonString);
    };
  }


  private RedisSerializer<String> keySerializer() {
    return new StringRedisSerializer();
  }

  private RedisSerializer<Object> valueSerializer() {
    ObjectMapper mapper = new ObjectMapper();
    //序列化的时候序列对象的所有属性
    mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
    mapper.registerModule(new JavaTimeModule());
//    mapper.activateDefaultTyping(PolymorphicTypeValidator, ObjectMapper.DefaultTyping, JsonTypeInfo.As);
    // 此项必须配置，否则会报java.lang.ClassCastException: java.util.LinkedHashMap cannot be cast to XXX
    mapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL, JsonTypeInfo.As.PROPERTY);
    return new GenericJackson2JsonRedisSerializer(mapper);
  }
}

/**
 * Value 序列化
 *
 * @author /
 * @param <T>
 */
class FastJsonRedisSerializer<T> implements RedisSerializer<T> {

  private final Class<T> clazz;

  FastJsonRedisSerializer(Class<T> clazz) {
    super();
    this.clazz = clazz;
  }

  @Override
  public byte[] serialize(T t) {
    if (t == null) {
      return new byte[0];
    }
    return JSON.toJSONString(t, SerializerFeature.WriteClassName).getBytes(StandardCharsets.UTF_8);
  }

  @Override
  public T deserialize(byte[] bytes) {
    if (bytes == null || bytes.length <= 0) {
      return null;
    }
    String str = new String(bytes, StandardCharsets.UTF_8);
    return JSON.parseObject(str, clazz);
  }

}