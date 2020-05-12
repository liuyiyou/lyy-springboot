package cn.liuyiyou.springboot.cache.redis.repository;

import cn.liuyiyou.springboot.cache.redis.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author: liuyiyou.cn
 * @date: 2020/5/12
 * @version: V1.0
 */
public interface UserRepository extends JpaRepository<User, Integer> {

}
