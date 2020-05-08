package cn.liuyiyou.springboot.sql.jpa;

import cn.liuyiyou.springboot.sql.jpa.entity.User;
import cn.liuyiyou.springboot.sql.jpa.repository.UserRepository;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ApplicationTests {

  @Autowired
  private UserRepository userRepository;

  @Test
  void contextLoads() {
    userRepository.findById(1);
  }
  @Test
  void save(){
    User user = new User();
    user.setName("lyy");
    user.setEmail("lyy@ab.com");
    userRepository.save(user);

    final List<User> all = userRepository.findAll();
    all.forEach(user1 -> System.out.println(user1.getEmail()));
  }

}
