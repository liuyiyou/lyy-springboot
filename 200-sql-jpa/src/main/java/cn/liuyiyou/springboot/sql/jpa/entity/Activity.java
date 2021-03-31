package cn.liuyiyou.springboot.sql.jpa.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import lombok.Data;

/**
 * 活动主表
 *
 * @author harry 2020-10-14
 */
@Data
@Entity
@Table(name = "activity")
public class Activity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id

    /**
     * id
     */
    @Size(max = 50)
    @Column(name = "id", length = 50)
    private String id;


    /**
     * 租户ID
     */
    @Size(max = 32)
    @Column(name = "tenant_id", length = 32)
    private String tenantId;


    /**
     * 名
     */
    @Size(max = 50)
    @Column(name = "name", length = 50)
    private String name;


    /**
     * 开始时间
     */
    @Column(name = "start_time")
    private Instant startTime;


    /**
     * 结束时间
     */
    @Column(name = "end_time")
    private Instant endTime;


    /**
     * 是否启用(默认有效1)
     */
    @Column(name = "status")
    private Boolean status;

    /**
     * 审核状态（1-草稿，2-待审核，3-已驳回，4-已通过）
     */
    @Column(name = "audit_status")
    private Integer auditStatus;


    /**
     * 审核、驳回意见
     */
    @Size(max = 255)
    @Column(name = "audit_msg", length = 255)
    private String auditMsg;


    /**
     * 用户是否已消费
     */
    @Column(name = "user_first_constraint")
    private Boolean userFirstConstraint;


    /**
     * 1-已消费 2-未消费
     */
    @Column(name = "user_first_type")
    private Integer userFirstType;


    /**
     * 有专场约束(如果没有就是全部商品)
     */
    @Column(name = "special_constraint")
    private Boolean specialConstraint;


    /**
     * 专场id
     */
    @Size(max = 32)
    @Column(name = "special_id", length = 32)
    private String specialId;


    /**
     * 礼包赠品数量约束
     */
    @Column(name = "gift_qty_constraint")
    private Integer giftQtyConstraint;


    /**
     * 用户等级约束
     */
    @Column(name = "user_grade_constraint")
    private Boolean userGradeConstraint;


    /**
     * 用户等级
     */
    @Size(max = 1000)
    @Column(name = "user_grade", length = 1000)
    private String userGrade;


    /**
     * 用户所在地，行政区码格式[[v1，v2]]
     */
    @Size(max = 1000)
    @Column(name = "user_zone", length = 1000)
    private String userZone;


    /**
     * 用户所在地约束，行政区码
     */
    @Column(name = "user_zone_constraint")
    private Boolean userZoneConstraint;


    /**
     * 用户是否已付费
     */
    @Column(name = "user_paid_constraint")
    private Boolean userPaidConstraint;


    /**
     * 订单商品数量约束
     */
    @Column(name = "order_item_qty_constraint")
    private Boolean orderItemQtyConstraint;


    /**
     * 订单商品数量
     */
    @Column(name = "order_item_qty")
    private Integer orderItemQty;


    /**
     * 订单金额约束
     */
    @Column(name = "order_amount_constraint")
    private Boolean orderAmountConstraint;


    /**
     * 订单金额
     */
    @Column(name = "order_amount")
    private BigDecimal orderAmount;


    /**
     * 参加次数，比如某些活动限参加一次
     */
    @Column(name = "join_tmie_constraint")
    private Integer joinTmieConstraint;


    /**
     * 是否必须持券入场
     */
    @Column(name = "is_coupon_required")
    private Boolean isCouponRequired;

    /**
     * 是否是兼容活动
     */
    @Column(name = "is_compatible")
    private Boolean isCompatible;
    /**
     * 兼容等级 用于活动互斥  兼容活动等级>普通活动等级 可兼容,则否之
     */
    @Column(name = "compatible_grade")
    private Integer compatibleGrade;


    /**
     * 是否全场
     */
    @Column(name = "is_all")
    private Boolean isAll;


    /**
     * 是否有抵扣
     */
    @Column(name = "has_discount")
    private Boolean hasDiscount;

    /**
     * 是否活动价
     */
    @Column(name = "has_activity_price")
    private Boolean hasActivityPrice;

     /**
     *  1.普通（其他） 2 秒杀 3 会员免费领取 4会员折扣活动
     */
    @Column(name = "type")
    private Integer type;


    /**
     * 1-满额减N元 2-满额支付N元 3-满额打折
     */
    @Column(name = "discount_type")
    private Integer discountType;


    /**
     * 抵扣金额，此字段没有或为零时抵扣比例有效
     */
    @Column(name = "discount_amount")
    private BigDecimal discountAmount;


    /**
     * 抵扣比例
     */
    @Column(name = "discount_rate")
    private BigDecimal discountRate;


    /**
     * 是否有礼品包，多个礼包时只可选一包
     */
    @Column(name = "has_gift_bag")
    private Boolean hasGiftBag;

    /**
     * 是否是红包活动
     */
    @Column(name = "has_red_pack")
    private Boolean hasRedPack;


    /**
     * 是否有券包，多个券包时只可选一包
     */
    @Column(name = "has_coupon_bag")
    private Boolean hasCouponBag;


    /**
     * 全场/每个商品限制数量
     */
    @Column(name = "limit_item_qty")
    private Integer limitItemQty;


    /**
     * 全场/用户每个sku限制数量
     */
    @Column(name = "user_limit_item_qty")
    private Integer userLimitItemQty;


    /**
     * 活动备注
     */
    @Size(max = 255)
    @Column(name = "remark", length = 255)
    private String remark;


    /**
     * 活动排序
     */
    @Column(name = "sort_order")
    private Integer sortOrder;


    /**
     * createdBy
     */
    @Size(max = 255)
    @Column(name = "created_by", length = 255)
    private String createdBy;


    /**
     * createdDate
     */
    @Column(name = "created_date")
    private Instant createdDate;


    /**
     * lastModifiedBy
     */
    @Size(max = 255)
    @Column(name = "last_modified_by", length = 255)
    private String lastModifiedBy;


    /**
     * lastModifiedDate
     */
    @Column(name = "last_modified_date")
    private Instant lastModifiedDate;


}