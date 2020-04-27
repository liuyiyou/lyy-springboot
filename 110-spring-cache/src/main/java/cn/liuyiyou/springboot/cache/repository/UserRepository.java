package cn.liuyiyou.springboot.cache.repository;

import cn.liuyiyou.springboot.cache.entity.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.stereotype.Repository;

/**
 * @author: liuyiyou.cn
 * @date: 2020/4/27
 * @version: V1.0
 */
//@NoRepositoryBean
@Repository
public interface UserRepository extends PagingAndSortingRepository<User, Integer>,
    QueryByExampleExecutor {

}
