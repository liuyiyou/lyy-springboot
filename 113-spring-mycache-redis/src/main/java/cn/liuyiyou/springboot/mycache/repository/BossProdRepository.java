package cn.liuyiyou.springboot.mycache.repository;

import cn.liuyiyou.springboot.mycache.entity.BossProd;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

/***
 *
 * @author: liuyiyou.cn
 * @date: 2020/5/7
 * @Copyright 2020 liuyiyou.cn Inc. All rights reserved
 */
//@Repository
public interface BossProdRepository extends PagingAndSortingRepository<BossProd, Long>,
    QueryByExampleExecutor {

}
