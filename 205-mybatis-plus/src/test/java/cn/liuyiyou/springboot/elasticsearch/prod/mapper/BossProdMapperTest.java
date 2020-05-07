package cn.liuyiyou.springboot.elasticsearch.prod.mapper;

import cn.liuyiyou.springboot.mybatisplus.Application;
import cn.liuyiyou.springboot.mybatisplus.prod.entity.BossProd;
import cn.liuyiyou.springboot.mybatisplus.prod.mapper.BossProdMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.util.Assert;

/***
 *
 * @author: liuyiyou.cn
 * @date: 2020/5/7
 * @Copyright 2020 liuyiyou.cn Inc. All rights reserved
 */
@SpringBootTest
@Import(Application.class)
@Slf4j
class BossProdMapperTest {

    @Autowired
    private BossProdMapper bossProdMapper;

    @Test
    public void testGetById() {
        BossProd bossProd = bossProdMapper.selectById(23200501L);
        Assert.notNull(bossProd, "bossProd不为空");
    }
}
