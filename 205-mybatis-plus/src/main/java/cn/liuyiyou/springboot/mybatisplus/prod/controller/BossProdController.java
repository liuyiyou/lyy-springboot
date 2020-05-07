package cn.liuyiyou.springboot.mybatisplus.prod.controller;


import cn.liuyiyou.springboot.mybatisplus.prod.service.IBossProdService;
import cn.liuyiyou.springboot.mybatisplus.prod.entity.BossProd;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
@RequestMapping("/prod/boss-prod")
public class BossProdController {


    @Autowired
    private IBossProdService bossProdService;

    @GetMapping("/{id}")
    public BossProd getById(@PathVariable Long id) {
        return bossProdService.getById(id);
    }

}
