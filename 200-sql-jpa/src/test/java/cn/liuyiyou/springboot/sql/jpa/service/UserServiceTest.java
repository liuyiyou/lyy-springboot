package cn.liuyiyou.springboot.sql.jpa.service;

import cn.liuyiyou.springboot.sql.jpa.MyTestsConfiguration;
import cn.liuyiyou.springboot.sql.jpa.entity.User;
import cn.liuyiyou.springboot.sql.jpa.entity.UserAddress;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

/**
 * @author: liuyiyou.cn
 * @date: 2020/6/4
 * @version: V1.0
 */
@SpringBootTest
@Import(MyTestsConfiguration.class)
class UserServiceTest {

  @Autowired
  private UserService userService;


  @DisplayName("一对一")
  @Test
  void oneToOne() {
    Optional<User> userOptional = userService.findUserById(1);
    User user = userOptional.get();
    Assertions.assertNotNull(user);
    UserAddress userAddress = user.getUserAddress();
    if (userAddress != null) {
      System.out.println(userAddress);
    }
  }


  @DisplayName("一对多")
  @Test
  void oneToMany() {
//    Optional<User> userOptional = userService.findUserById(1);
//    User user = userOptional.get();
//    Assertions.assertNotNull(user);
//    UserAddress userAddress = user.getUserAddressList();
//    if (userAddress != null) {
//      System.out.println(userAddress);
//    }
  }

  @DisplayName("根据用户ID查找用户")
  @Test
  void findUserById() {
    Optional<User> userOptional = userService.findUserById(1);
    User user = userOptional.get();
    System.out.println(user);
    UserAddress userAddress = user.getUserAddress();
    if (user != null && userAddress != null) {
      System.out.println(userAddress);
    }
    Assertions.assertNotNull(user);
  }

  @DisplayName("查找所有用户")
  @Test
  void getAll() {
    final List<User> all = userService.getAll();
    System.out.println(all);
  }

  @Test
  void save() {
  }
}