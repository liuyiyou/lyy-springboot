package cn.liuyiyou.springboot.sql.jpa.service;

import static org.junit.jupiter.api.Assertions.*;

import cn.liuyiyou.springboot.sql.jpa.MyTestsConfiguration;
import cn.liuyiyou.springboot.sql.jpa.entity.User;
import cn.liuyiyou.springboot.sql.jpa.entity.UserAddress;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

/**
 * @author: liuyiyou.cn
 * @date: 2020/6/9
 * @version: V1.0
 */
@SpringBootTest
@Import(MyTestsConfiguration.class)
class UserAddressServiceTest {

  @Autowired
  private UserAddressService userAddressService;

  @DisplayName("查找所有用户")
  @Test
  void getAll() {
    final List<UserAddress> all = userAddressService.getAll();
    System.out.println(all);
  }

  @Test
  void save() {
  }

  @Test
  void findUserAddreById() {
  }
}