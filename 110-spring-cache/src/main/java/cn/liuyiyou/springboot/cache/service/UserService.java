package cn.liuyiyou.springboot.cache.service;

import cn.liuyiyou.springboot.cache.entity.User;
import cn.liuyiyou.springboot.cache.repository.UserRepository;
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
  private UserRepository userRepository;

  public User save(User user) {
    return userRepository.save(user);
  }

  public Optional<User> findUserById(Integer id) {
    Optional<User> userOptional = userRepository.findById(id);
    return userOptional;
  }


  public void deleteById(Integer id){
    userRepository.deleteById(id);
  }




}
