package cn.liuyiyou.springboot.cache.redis.service;

import cn.liuyiyou.springboot.cache.redis.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author: liuyiyou.cn
 * @date: 2020/4/27
 * @version: V1.0
 */
@Service
@Slf4j
public class UserService {

  public User save(User user){
    log.info("UserService#save");
    return user;
  }

  public User findUserById(Integer id) {
    log.info("到了服务层");
    User user = new User();
    user.setId(id);
    user.setName("lyy");
    return user;
  }


}
