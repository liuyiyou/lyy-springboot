package cn.liuyiyou.springboot.elasticsearch.prod.controller;


import cn.liuyiyou.springboot.elasticsearch.prod.entity.BossProd;
import cn.liuyiyou.springboot.elasticsearch.prod.entity.es.EsBossProd;
import cn.liuyiyou.springboot.elasticsearch.prod.repository.es.BossProdEsRepository;
import cn.liuyiyou.springboot.elasticsearch.prod.repository.jpa.BossProdJpaRepository;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.Spliterator;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * <p>
 * BOSS 商品信息表，支持：
 * <p>
 * 1、对原子商品 prod 的继承扩展 。 这种情况下，只是将prod 里面的记录附加一下洋老板平台的必要信息 。
 * <p>
 * 2、对原子商品，商品SKU的组合打包。这种情况下，则是对不同原子商品(基础商品)组合，然后重新定义SKU。 前端控制器
 * </p>
 *
 * @author liuyiyou
 * @since 2020-05-07
 */
@RestController
@RequestMapping("/prod/boss-prod/es")
@Slf4j
public class BossProdEsController {

    @Autowired
    private BossProdJpaRepository bossProdJpaRepository;
    @Autowired
    private BossProdEsRepository bossProdEsRepository;
    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;


    @GetMapping("/initMapping")
    public String initMapping() {
        elasticsearchTemplate.deleteIndex(EsBossProd.class);
        elasticsearchTemplate.createIndex(EsBossProd.class);   // 创建索引
        elasticsearchTemplate.putMapping(EsBossProd.class);   // 设置映射
        return "success";
    }


    @GetMapping("/initData")
    public String initData() {
        bossProdEsRepository.deleteAll();
        Spliterator<BossProd> bossProdSpliterator = bossProdJpaRepository.findAll().spliterator();
        List<EsBossProd> esBossProds = StreamSupport.stream(bossProdSpliterator, false)
                .map(bossProd -> {
                    EsBossProd esBossProd = new EsBossProd();
                    BeanUtils.copyProperties(bossProd, esBossProd);
                    esBossProd.setId(bossProd.getBossProdId());
                    return esBossProd;
                }).collect(Collectors.toList());
        bossProdEsRepository.saveAll(esBossProds);
        return "success";
    }


    @GetMapping("/{id}")
    public EsBossProd getById(@PathVariable Long id) {
        Optional<EsBossProd> bossProd = bossProdEsRepository.findById(id);
        return bossProd.orElse(new EsBossProd());
    }


    @GetMapping("/name/{prodName}")
    public List<EsBossProd> getBossProdBName(@PathVariable String prodName) {
        List<EsBossProd> esBossProdList = bossProdEsRepository.findByProdName(prodName);
        return esBossProdList;
    }


    @GetMapping("/query")
    public Page<EsBossProd> query(@RequestParam("keyword") String keyword) {
        QueryBuilder queryCondition = QueryBuilders.termQuery("prodName", keyword);
        log.info(queryCondition.toString());
        Page<EsBossProd> search = bossProdEsRepository.search(queryCondition, PageRequest.of(0, 10));
        return search;
    }
}
