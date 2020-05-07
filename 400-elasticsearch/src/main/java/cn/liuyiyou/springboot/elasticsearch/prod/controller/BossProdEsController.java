package cn.liuyiyou.springboot.elasticsearch.prod.controller;


import cn.liuyiyou.springboot.elasticsearch.prod.entity.es.EsBossProd;
import cn.liuyiyou.springboot.elasticsearch.prod.repository.es.BossProdEsRepository;
import cn.liuyiyou.springboot.elasticsearch.prod.repository.jpa.BossProdJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

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
public class BossProdEsController {

    @Autowired
    private BossProdJpaRepository bossProdJpaRepository;

    @Autowired
    private BossProdEsRepository bossProdEsRepository;

    @GetMapping("/initMapping")
    public String initMapping() {
        return "";
    }


    @GetMapping("/initData")
    public String initData() {
        return "";
    }


    @GetMapping("/{id}")
    public EsBossProd getById(@PathVariable Long id) {
        Optional<EsBossProd> bossProd = bossProdEsRepository.findById(id);
        return bossProd.orElse(new EsBossProd());
    }
}
