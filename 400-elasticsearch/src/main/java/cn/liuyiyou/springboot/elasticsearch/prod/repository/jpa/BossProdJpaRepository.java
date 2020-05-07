package cn.liuyiyou.springboot.elasticsearch.prod.repository.jpa;

import cn.liuyiyou.springboot.elasticsearch.prod.entity.BossProd;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.stereotype.Repository;

/***
 *
 * @author: liuyiyou.cn
 * @date: 2020/5/7
 * @Copyright 2020 liuyiyou.cn Inc. All rights reserved
 */
//@Repository
public interface BossProdJpaRepository extends PagingAndSortingRepository<BossProd, Long>,
        QueryByExampleExecutor {

}
