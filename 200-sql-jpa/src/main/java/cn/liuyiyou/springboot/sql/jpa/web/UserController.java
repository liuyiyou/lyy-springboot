package cn.liuyiyou.springboot.sql.jpa.web;

import cn.liuyiyou.springboot.sql.jpa.entity.User;
import cn.liuyiyou.springboot.sql.jpa.repository.UserRepository;
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
  private UserRepository userRepository;

  @GetMapping("/{id}")
  public Optional<User> get(@PathVariable("id") Integer id) {
    return userRepository.findById(id);
  }

  @GetMapping("/save")
  public User save(Integer id, String name) {
    User user = new User();
    user.setId(id);
    user.setName(name);
    return userRepository.save(user);
  }

}
