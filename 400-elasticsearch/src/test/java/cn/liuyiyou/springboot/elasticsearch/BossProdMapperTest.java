//package cn.liuyiyou.springboot.elasticsearch;
//
//import cn.liuyiyou.springboot.elasticsearch.prod.entity.BossProd;
//import cn.liuyiyou.springboot.elasticsearch.prod.repository.jpa.BossProdJpaRepository;
//import lombok.extern.slf4j.Slf4j;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.context.annotation.Import;
//
//import java.util.Optional;
//
///***
// *
// * @author: liuyiyou.cn
// * @date: 2020/5/7
// * @Copyright 2020 liuyiyou.cn Inc. All rights reserved
// */
//@SpringBootTest
//@Import(ElasticsearchApplication.class)
//@Slf4j
//class BossProdMapperTest {
//
//    @Autowired
//    private BossProdJpaRepository bossProdRepository;
//
//    @Test
//    public void testGetById() {
//        Optional<BossProd> bossProdOptional = bossProdRepository.findById(23200501L);
//        bossProdOptional.ifPresent(bossProd -> log.info(bossProd.getProdName()));
//    }
//}
