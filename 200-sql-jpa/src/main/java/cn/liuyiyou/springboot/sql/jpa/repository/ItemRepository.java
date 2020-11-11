package cn.liuyiyou.springboot.sql.jpa.repository;

import cn.liuyiyou.springboot.sql.jpa.entity.Item;
import org.springframework.data.repository.CrudRepository;

/**
 * @author: liuyiyou.cn
 * @date: 2020/11/10
 * @version: V1.0
 */
public interface ItemRepository extends CrudRepository<Item, Integer> {

}
