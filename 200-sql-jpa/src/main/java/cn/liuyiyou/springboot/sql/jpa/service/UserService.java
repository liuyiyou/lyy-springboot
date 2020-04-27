package cn.liuyiyou.springboot.sql.jpa.service;

import cn.liuyiyou.springboot.sql.jpa.entity.User;
import cn.liuyiyou.springboot.sql.jpa.repository.UserRepository;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: liuyiyou.cn
 * @date: 2020/4/27
 * @version: V1.0
 */
@Service
@Slf4j
public class UserService {

  @Autowired
  private UserRepository  userRepository;

  public User save(User user) {
    return userRepository.save(user);
  }

  public Optional<User> findUserById(Integer id) {
    Optional<User> userOptional = userRepository.findById(id);
    return userOptional;
  }


}
