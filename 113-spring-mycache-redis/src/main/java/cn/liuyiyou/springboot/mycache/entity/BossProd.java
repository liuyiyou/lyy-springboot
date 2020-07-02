package cn.liuyiyou.springboot.mycache.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * BOSS 商品信息表，支持：
 * <p>
 * 1、对原子商品 prod 的继承扩展 。 这种情况下，只是将prod 里面的记录附加一下洋老板平台的必要信息 。
 * <p>
 * 2、对原子商品，商品SKU的组合打包。这种情况下，则是对不同原子商品(基础商品)组合，然后重新定义SKU。
 * </p>
 *
 * @author liuyiyou
 * @since 2020-05-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@Entity
public class BossProd implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * BOSS产品标识
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bossProdId;

    /**
     * 产品名称
     */
    private String prodName;

    /**
     * 原子产品标识：
     * prod_type=0 则 取prod.prod_id;
     * prod_type=1，填 0。 此时则通过prod_group来定义。。
     */
    private Long prodId;

    /**
     * 销售渠道： product_sale_channel.channel_id
     * <p>
     * 1	跨境保税
     * 2	跨境直邮
     * 3	国际快件（不包税）
     * 4	国际快件（包税）
     * 5	完税
     */
    private Integer saleChannel;

    /**
     * 税率id
     */
    private Integer taxId;

    /**
     * 发货地
     */
    private String origin;

    /**
     * 商品供应商ID，引用ibalife_base.base_supplier.supplier_id
     */
    private Integer supplierId;

    /**
     * 产品状态： 1 - 上架，2 - 下架，3－删除
     */
    private Integer status;

    /**
     * 状态变换日期 (上架日期下架日期)
     */
    private LocalDateTime statusTime;

    /**
     * 创建日期
     */
    private LocalDateTime createTime;

    /**
     * 最后一次修改的UNIX时间戳，用于排序，静态页面版本控制。
     */
    private Integer lastUpdate;

    /**
     * 商品同步至营销系统时间
     */
    private LocalDateTime syncDrawTime;

    /**
     * 运费模板: 用户运费模板ID
     */
    private Long userFreightTemplateId;

    /**
     * 运费模板: 供应商运费模板ID
     */
    private Long supplierFreightTemplateId;


}
