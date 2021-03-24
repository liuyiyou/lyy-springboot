package cn.liuyiyou.boot.repository;

import cn.liuyiyou.boot.entity.User;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author: liuyiyou.cn
 * @date: 2021/3/20
 * @version: V1.0
 */
public interface UserRepository extends PagingAndSortingRepository<User, Integer> {

    List<User> findByName(String name);
}
