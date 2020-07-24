package cn.liuyiyou.springboot.repository;

import cn.liuyiyou.springboot.entity.Cart;
import org.springframework.stereotype.Repository;

/**
 * @author: liuyiyou.cn
 * @date: 2020/7/24
 * @version: V1.0
 */
@Repository
public interface CartRepository extends GenericRepository<Cart, Integer> {

}
