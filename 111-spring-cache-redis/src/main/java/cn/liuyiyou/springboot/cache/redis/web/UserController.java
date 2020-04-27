package cn.liuyiyou.springboot.cache.redis.web;

import cn.liuyiyou.springboot.cache.redis.entity.User;
import cn.liuyiyou.springboot.cache.redis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: liuyiyou.cn
 * @date: 2020/4/27
 * @version: V1.0
 */
@RestController
@RequestMapping("/users")
public class UserController {

  @Autowired
  private UserService userService;

  @GetMapping("/{id}")
  @Cacheable(value = "user", key = "#id")
  public User get(@PathVariable("id") Integer id) {
    return userService.findUserById(id);
  }

  @GetMapping("/save")
  @CachePut(value = "user", key = "#id")
  public User save(Integer id, String name) {
    User user = new User();
    user.setId(id);
    user.setName(name);
    return userService.save(user);
  }

}
