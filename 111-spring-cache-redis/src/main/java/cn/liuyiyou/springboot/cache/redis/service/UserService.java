package cn.liuyiyou.springboot.cache.redis.service;

import cn.liuyiyou.springboot.cache.redis.annotation.GetCache;
import cn.liuyiyou.springboot.cache.redis.annotation.PutCache;
import cn.liuyiyou.springboot.cache.redis.entity.User;
import cn.liuyiyou.springboot.cache.redis.repository.UserRepository;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @author: liuyiyou.cn
 * @date: 2020/4/27
 * @version: V1.0
 */
@Service
@Slf4j
@CacheConfig(cacheNames = "users")
public class UserService {

  @Autowired
  private UserRepository userRepository;

  //访问方式： http://localhost:8080/users/save?id=2&name=lyy2

  // @CachePut(value = "user",key = "#user.id")  <==>  redisKey=  user::User(id=2, name=lyy2, email=null)
  // @CachePut(value = "user",key = "#user.id")  <==>  redisKey = user::1
//  @CachePut(value = "user", key = "#user.id")
  public User save(User user) {
    userRepository.save(user);
    return user;
  }

  /**
   * @Caching(evict = {
   * @CacheEvict(value = "user", key = "#id") }, put = {@CachePut(value = "user", key = "#id")})
   */
//  @CacheEvict(value = "user", key = "#id")
//  @CachePut(value = "user", key = "#id")
  @PutCache
  public User updateEmail(Integer id, String emial) {
    User user = userRepository.save(findById(id).setEmail(emial));
    return user;
  }

  //http://localhost:8080/users/1

//  @Cacheable(value = "user", key = "#id")
  @GetCache
  public User findById(Integer id) {
    Optional<User> userOptional = userRepository.findById(id);
    return userOptional
        .orElseThrow(() -> new RuntimeException(String.format("User.id=%s Not Found", id)));
  }

  @GetCache(key = "#id")
  public User findById2(Integer id) {
    Optional<User> userOptional = userRepository.findById(id);
    return userOptional
        .orElseThrow(() -> new RuntimeException(String.format("User.id=%s Not Found", id)));
  }



  @CacheEvict(value = "user", key = "#id")
  public void delete(Integer id) {
    userRepository.deleteById(id);
  }

  @CacheEvict(value = "user", allEntries = true)
  public void deleteAll() {
    userRepository.deleteAll();
  }

}
