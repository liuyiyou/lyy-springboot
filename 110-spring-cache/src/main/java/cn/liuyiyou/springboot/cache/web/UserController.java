package cn.liuyiyou.springboot.cache.web;

import cn.liuyiyou.springboot.cache.entity.User;
import cn.liuyiyou.springboot.cache.service.UserService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
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

  @GetMapping("")
  public List<User> list(){
   return  userService.findAll();
  }

  @GetMapping("/{id}")
  public Optional<User> get(@PathVariable("id") Integer id) {
    return userService.findUserById(id);
  }

  @GetMapping("/save")
  public User save(Integer id, String name) {
    User user = new User();
    user.setId(id);
    user.setName(name);
    return userService.save(user);
  }

  @GetMapping("/delete")
  public void deleteById(Integer id) {
    userService.deleteById(id);
  }


  @GetMapping("/deleteAll")
  public void deleteAll(Integer id) {
    userService.deleteById(id);
  }
}
