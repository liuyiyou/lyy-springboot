package cn.liuyiyou.springboot.elasticsearch.prod.repository.es;

import cn.liuyiyou.springboot.elasticsearch.prod.entity.es.EsBossProd;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/***
 *
 * @author: liuyiyou.cn
 * @date: 2020/5/7
 * @Copyright 2020 liuyiyou.cn Inc. All rights reserved
 */
//@NoRepositoryBean
public interface BossProdEsRepository extends ElasticsearchRepository<EsBossProd, Long> {

}
