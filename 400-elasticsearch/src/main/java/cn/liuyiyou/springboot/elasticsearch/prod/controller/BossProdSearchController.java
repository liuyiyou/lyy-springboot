package cn.liuyiyou.springboot.elasticsearch.prod.controller;

import cn.hutool.json.JSONUtil;
import cn.liuyiyou.springboot.elasticsearch.prod.entity.es.EsBossProd;
import cn.liuyiyou.springboot.elasticsearch.prod.repository.es.BossProdEsRepository;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.TermQueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/***
 *
 * @author: liuyiyou.cn
 * @date: 2020/5/7
 * @Copyright 2020 liuyiyou.cn Inc. All rights reserved
 */
@RestController
@Slf4j
public class BossProdSearchController {

    @Autowired
    private BossProdEsRepository bossProdEsRepository;

    /**
     * 单匹配查询
     *
     * @param key
     */
    @GetMapping("/query")
    public Page<EsBossProd>  termQuery(String key) {
        //单匹配不分词
        TermQueryBuilder termQueryBuilder = QueryBuilders.termQuery("prodName", key);
        Page<EsBossProd> termSearch = bossProdEsRepository.search(termQueryBuilder, PageRequest.of(0, 10));
        log.info(JSONUtil.toJsonStr(termSearch.getContent()));

        //单匹配分词
        MatchQueryBuilder matchQueryBuilder = QueryBuilders.matchQuery("prodName", key);
        Page<EsBossProd> matchSsearch = bossProdEsRepository.search(matchQueryBuilder, PageRequest.of(0, 10));
        log.info(JSONUtil.toJsonStr(matchSsearch.getContent()));
        return matchSsearch;
    }


}
