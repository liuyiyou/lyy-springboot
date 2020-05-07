package cn.liuyiyou.springboot.mybatisplus.prod.service.impl;

import cn.liuyiyou.springboot.mybatisplus.prod.entity.BossProd;
import cn.liuyiyou.springboot.mybatisplus.prod.mapper.BossProdMapper;
import cn.liuyiyou.springboot.mybatisplus.prod.service.IBossProdService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * BOSS 商品信息表，支持：

1、对原子商品 prod 的继承扩展 。 这种情况下，只是将prod 里面的记录附加一下洋老板平台的必要信息 。

2、对原子商品，商品SKU的组合打包。这种情况下，则是对不同原子商品(基础商品)组合，然后重新定义SKU。 服务实现类
 * </p>
 *
 * @author liuyiyou
 * @since 2020-05-07
 */
@Service
public class BossProdServiceImpl extends ServiceImpl<BossProdMapper, BossProd> implements IBossProdService {

}
