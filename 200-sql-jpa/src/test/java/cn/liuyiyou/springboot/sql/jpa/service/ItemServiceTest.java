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
class ItemServiceTest {

  @Autowired
  private ItemService itemService;

  @DisplayName("CriteriaQuery查询")
  @Test
  void oneToOne() {
    itemService.list();
  }

}