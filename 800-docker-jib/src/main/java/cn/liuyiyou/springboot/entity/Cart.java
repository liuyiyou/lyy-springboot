package cn.liuyiyou.springboot.entity;

/**
 * @author: liuyiyou.cn
 * @date: 2020/7/24
 * @version: V1.0
 */

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import lombok.Data;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * 购物车商品表
 *
 * @author Tony Luo 2020-07-24
 */
@Data
@Entity
@Table(name = "litemall_cart")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Cart implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  /**
   * id
   */
  @Column(name = "id")
  private Integer id;

  /**
   * 用户表的用户ID
   */
  @Column(name = "user_id")
  private Integer userId;

  /**
   * 商品表的商品ID
   */
  @Column(name = "goods_id")
  private Integer goodsId;

  /**
   * 商品编号
   */
  @Size(max = 63)
  @Column(name = "goods_sn", length = 63)
  private String goodsSn;

  /**
   * 商品名称
   */
  @Size(max = 127)
  @Column(name = "goods_name", length = 127)
  private String goodsName;

  /**
   * 商品货品表的货品ID
   */
  @Column(name = "product_id")
  private Integer productId;

  /**
   * 商品货品的价格
   */
  @Column(name = "price")
  private BigDecimal price;

  /**
   * 商品货品的数量
   */
  @Column(name = "number")
  private Integer number;

  /**
   * 商品规格值列表，采用JSON数组格式
   */
  @Size(max = 1023)
  @Column(name = "specifications", length = 1023)
  private String specifications;

  /**
   * 购物车中商品是否选择状态
   */
  @Column(name = "checked")
  private Boolean checked;

  /**
   * 商品图片或者商品货品图片
   */
  @Size(max = 255)
  @Column(name = "pic_url", length = 255)
  private String picUrl;

  /**
   * 创建时间
   */
  @Column(name = "add_time")
  private Instant addTime;

  /**
   * 更新时间
   */
  @Column(name = "update_time")
  private Instant updateTime;

  /**
   * 逻辑删除
   */
  @Column(name = "deleted")
  private Boolean deleted;


}

