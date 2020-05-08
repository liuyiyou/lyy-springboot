package cn.liuyiyou.springboot.sql.jpa.repository;

import cn.liuyiyou.springboot.sql.jpa.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author: liuyiyou.cn
 * @date: 2020/4/27
 * @version: V1.0
 */
//@NoRepositoryBean
//@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
