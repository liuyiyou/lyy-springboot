package cn.liuyiyou.springboot.cache.service;

import cn.liuyiyou.springboot.cache.entity.User;
import cn.liuyiyou.springboot.cache.repository.UserRepository;
import com.google.common.collect.Lists;
import java.util.List;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
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

    @CachePut(value = "user", key = "#id")
    public User save(User user) {
        log.info("新增用户:{}", user);
        return userRepository.save(user);
    }


    @Cacheable(value = "user", key = "#id")
    public Optional<User> findUserById(Integer id) {
        log.info("ID:[{}]从数据库获取",id);
        return userRepository.findById(id);
    }

    @CacheEvict(value = "user", key = "#id")
    public void deleteById(Integer id) {
        log.info("ID:[{}]从数据库删除",id);
        userRepository.deleteById(id);
    }

    @CacheEvict(value = "user", allEntries = true)
    public void deleteAll() {
        userRepository.deleteAll();
    }

    public List<User> findAll() {
        log.info("查询用户:");
        return Lists.newArrayList(userRepository.findAll());
    }
}
