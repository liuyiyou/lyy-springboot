package cn.liuyiyou.springboot.cache.redis;

import cn.liuyiyou.springboot.cache.redis.entity.User;
import java.util.Optional;
import org.junit.jupiter.api.Test;

/**
 * @author: liuyiyou.cn
 * @date: 2020/5/12
 * @version: V1.0
 */
public class OptionalTest {

  @Test
  public void optionalTst() {
    final User user = new User().setEmail("aa").setId(11);
    Object o = Optional.ofNullable(user).orElseGet(null);
    System.out.println(o);

    final String format = String.format("User.id=%s Not Found", 1);
    System.out.println(format);
  }
}
