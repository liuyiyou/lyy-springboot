package cn.liuyiyou.springboot.sql.jpa.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import java.lang.String;
import java.io.Serializable;
import java.time.Instant;
import java.math.BigDecimal;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Data;
/**
 * 订单表
 *
 * @author next auto generator 2020-12-20
 */
@Data
@Entity
@Table(name = "`order`")
public class Order implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id

    /**
     * 订单id
     */
    @Size(max = 32)
    @Column(name = "id", length = 32)
    private String id;


    /**
     * 租户ID
     */
    @Size(max = 32)
    @Column(name = "tenant_id", length = 32)
    private String tenantId;


    /**
     * 店铺id
     */
    @Size(max = 32)
    @Column(name = "shop_id", length = 32)
    private String shopId;


    /**
     * 买家id
     */
    @Size(max = 32)
    @Column(name = "buyer_id", length = 32)
    private String buyerId;


    /**
     * 买家姓名
     */
    @Size(max = 32)
    @Column(name = "buyer_name", length = 32)
    private String buyerName;


    /**
     * 买家手机号
     */
    @Size(max = 11)
    @Column(name = "buyer_mobile", length = 11)
    private String buyerMobile;


    /**
     * 卖家id
     */
    @Size(max = 32)
    @Column(name = "seller_id", length = 32)
    private String sellerId;


    /**
     * 外部订单编号
     */
    @Size(max = 64)
    @Column(name = "outer_order_id", length = 64)
    private String outerOrderId;


    /**
     * 收货人姓名
     */
    @Size(max = 20)
    @Column(name = "consignee_name", length = 20)
    private String consigneeName;


    /**
     * 收货人电话
     */
    @Size(max = 20)
    @Column(name = "consignee_mobile", length = 20)
    private String consigneeMobile;


    /**
     * 收货人身份证
     */
    @Size(max = 55)
    @Column(name = "consignee_id_card", length = 55)
    private String consigneeIdCard;


    /**
     * 收货地址json字符串
     */
    @Size(max = 256)
    @Column(name = "consignee_address", length = 256)
    private String consigneeAddress;


    /**
     * 收货城市
     */
    @Column(name = "consignee_city")
    private Integer consigneeCity;


    /**
     * 商品总额
     */
    @NotNull
    @Column(name = "total_amount", nullable = false)
    private BigDecimal totalAmount;


    /**
     * 运费
     */
    @Column(name = "freight_fee")
    private BigDecimal freightFee;


    /**
     * 税费
     */
    @Column(name = "tax_fee")
    private BigDecimal taxFee;


    /**
     * 抵扣金额
     */
    @Column(name = "discount_amount")
    private BigDecimal discountAmount;


    /**
     * 实付金额(实付金额=商品总金额 + 运费+税费 - 抵扣金额)
     */
    @NotNull
    @Column(name = "pay_amount", nullable = false)
    private BigDecimal payAmount;


    /**
     * 发货方式 1-门店自提，2-门店配送，3-快递配送
     */
    @Column(name = "delivery_type")
    private Integer deliveryType;


    /**
     * 创建时间
     */
    @Column(name = "created_time")
    private Instant createdTime;


    /**
     * 支付时间
     */
    @Column(name = "pay_time")
    private Instant payTime;


    /**
     * 审核时间
     */
    @Column(name = "check_time")
    private Instant checkTime;


    /**
     * 发货时间
     */
    @Column(name = "delivery_time")
    private Instant deliveryTime;


    /**
     * 确认收货时间
     */
    @Column(name = "confirm_time")
    private Instant confirmTime;


    /**
     * 关闭时间
     */
    @Column(name = "close_time")
    private Instant closeTime;


    /**
     * 订单状态，0正常，1纠分中断
     */
    @Column(name = "order_status")
    private Integer orderStatus;


    /**
     * 清关状态(0-未报海关;1-已报海关;2-海关单证放行;3-海关不受理;4-海关查验/转人工/挂起;5-海关单证审核不通过)
     */
    @Column(name = "customs_status")
    private Boolean customsStatus;


    /**
     * 是否包含跨境商品
     */
    @Column(name = "contain_cross_item")
    private Boolean containCrossItem;


    /**
     * 是否已经付款。
     */
    @Column(name = "is_paid")
    private Boolean isPaid;


    /**
     * 是否审核。付款之后，发货或推单之前的备用状态
     */
    @Column(name = "is_checked")
    private Boolean isChecked;


    /**
     * 是否部分发货。
     */
    @Column(name = "is_delivered_partially")
    private Boolean isDeliveredPartially;


    /**
     * 是否全部发货。
     */
    @Column(name = "is_delivered")
    private Boolean isDelivered;


    /**
     * 是否部分收货。
     */
    @Column(name = "is_consigned_partially")
    private Boolean isConsignedPartially;


    /**
     * 是否全部收货。
     */
    @Column(name = "is_consigned")
    private Boolean isConsigned;


    /**
     * 是否交易关闭
     */
    @Column(name = "is_trading_closed")
    private Boolean isTradingClosed;


    /**
     * 是否交易完成。
     */
    @Column(name = "is_finish")
    private Boolean isFinish;


    /**
     * 是否已通知发货
     */
    @Column(name = "is_notify_delivery")
    private Boolean isNotifyDelivery;


    /**
     * 是否为异常订单
     */
    @Column(name = "is_abnormal")
    private Boolean isAbnormal;


    /**
     * 处理状态(0-未处理;1-已处理)
     */
    @Column(name = "handle_status")
    private Boolean handleStatus;


    /**
     * 支付异常
     */
    @Column(name = "is_pay_abnormal")
    private Boolean isPayAbnormal;


    /**
     * 是否拼团订单
     */
    @Column(name = "is_groupbuy")
    private Boolean isGroupbuy;


    /**
     * 税费类型(0-完税 1-直邮 2-保税)
     */
    @Column(name = "tax_type")
    private Integer taxType;


}
