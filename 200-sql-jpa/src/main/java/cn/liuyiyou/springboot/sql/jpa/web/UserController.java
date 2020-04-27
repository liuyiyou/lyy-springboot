package cn.liuyiyou.springboot.sql.jpa.web;

import cn.liuyiyou.springboot.sql.jpa.entity.User;
import cn.liuyiyou.springboot.sql.jpa.service.UserService;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
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

}
