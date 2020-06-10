package cn.liuyiyou.springboot.sql.jpa.repository;

import cn.liuyiyou.springboot.sql.jpa.entity.UserAddress;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author: liuyiyou.cn
 * @date: 2020/4/27
 * @version: V1.0
 */
//@NoRepositoryBean
//@Repository
public interface UserAddressRepository extends JpaRepository<UserAddress, Integer> {

}
