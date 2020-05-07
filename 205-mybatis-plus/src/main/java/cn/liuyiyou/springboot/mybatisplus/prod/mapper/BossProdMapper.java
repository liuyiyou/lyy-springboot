package cn.liuyiyou.springboot.mybatisplus.prod.mapper;

import cn.liuyiyou.springboot.mybatisplus.prod.entity.BossProd;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * BOSS 商品信息表，支持：

1、对原子商品 prod 的继承扩展 。 这种情况下，只是将prod 里面的记录附加一下洋老板平台的必要信息 。

2、对原子商品，商品SKU的组合打包。这种情况下，则是对不同原子商品(基础商品)组合，然后重新定义SKU。 Mapper 接口
 * </p>
 *
 * @author liuyiyou
 * @since 2020-05-07
 */
@Repository
public interface BossProdMapper extends BaseMapper<BossProd> {

}
