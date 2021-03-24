package cn.liuyiyou.springboot.sql.jpa.repository;

import cn.liuyiyou.springboot.sql.jpa.entity.Activity;
import org.springframework.data.repository.CrudRepository;

/**
 * @author: liuyiyou.cn
 * @date: 2021/3/24
 * @version: V1.0
 */
public interface ActivityRepository extends CrudRepository<Activity, Integer> {

}
