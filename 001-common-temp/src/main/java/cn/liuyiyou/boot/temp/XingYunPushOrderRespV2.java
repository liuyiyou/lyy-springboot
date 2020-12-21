package cn.liuyiyou.boot.temp;

import com.alibaba.fastjson.annotation.JSONField;
import java.io.Serializable;
import java.util.List;
import lombok.Data;

/**
 * 天行云2.0 生成订单回调通知
 */
@Data
public class XingYunPushOrderRespV2 implements Serializable {


    public static final int ORDER_STATUS_SUCCESS = 1;


    @JSONField(name = "ret_code")
    private String retCode;//业务结果返回
    @JSONField(name = "ret_msg")
    private String retMsg;//业务结果描述返回
    @JSONField(name = "sign_type")
    private String signType;//加密方式:MD5(大写)
    @JSONField(name = "sign")
    private String sign;//MD5加密串
    @JSONField(name = "notice_code")
    private String noticeCode;//MD5加密串
    @JSONField(name = "merchant_order_id")
    private String merchantOrderId;   //  商家订单号
    @JSONField(name = "is_success")
    private int isSuccess;   //  订单生成状态（1生成成功，2生成失败）
    @JSONField(name = "generate_fail_type")
    private int generateFailType;   //  生成失败类型（1.帐户余额不足，2.库存不足，3,一单多品不在同一个仓库,4.KA未设置报价，5.KA未选品，6.商品已下架，7.未设置扣点 8.sku编码不存在 9.商品SPU编码不存在 10.购买数量小于批次规格起发量 11.无对应规格值批次 12.没有可选批次 13.不支持该收货地址发货 14.保税，部分直邮商品下单身份证正反面不能为空 15.保税订单存在非保税商品或非保税订单存在保税商品）
    @JSONField(name = "order_id")
    private String orderId;   //  行云订单号（拆分的订单号,注意：生成失败时为空）
    @JSONField(name = "order_freight_amount")
    private String orderFreightAmount;   //  订单运费合计(业务成功则有返回)（单位：元，保留两位小数）
    @JSONField(name = "order_tax_amount")
    private String orderTaxAmount;   //  综合税费合计（业务成功则有返回）（单位：元，保留两位小数）
    @JSONField(name = "order_tax_difference")
    private String orderTaxDifference;   //  综合税差合计（分）【保税和直邮订单返回该字段，非保税返回0】 （单位：元，保留两位小数）
    @JSONField(name = "order_pay_amount")
    private String orderPayAmount;   //  实际支付总金额（分）（单位：元，保留两位小数）
    @JSONField(name = "shop_discount_amount")
    private String shopDiscountAmount;   //  店铺优惠合计（单位：元，保留两位小数）
    @JSONField(name = "platform_discount_amount")
    private String platformDiscountAmount;   //  平台优惠合计(单位：元，保留两位小数)
    @JSONField(name = "order_list")
    private List<ChildOrder> orderList;   //  子订单数组

    //发货通知使用
    @JSONField(name = "order_status")
    private int[] orderStatus;//订单状态（1.待付款 2.待确认 3.通关中 4.待推送 5.待发货 6.待收货 7.已完成 8.已取消）
    @JSONField(name = "biz_order_id")
    private String bizOrderId;//业务单号(通知确认时需要回传)
    @JSONField(name = "express_list")
    private List<Express> expressList;//商品数组


    @Data
    public static class Express {
        @JSONField(name = "express_code")
        private String expressCode;   //  快递公司编码
        @JSONField(name = "express_company")
        private String expressCompany;   // 快递公司名称
        @JSONField(name = "express_order")
        private String expressOrder;   // 快递单号
        @JSONField(name = "sku_list")
        private List<ExpressSku> skuList;   // 商品数组

        private String orderId;
    }

    @Data
    public static class ExpressSku {
        @JSONField(name = "sku_code")
        private String skuCode;//商品编码（sku_code）
        @JSONField(name = "package_num")
        private int packageNum;//包装规格【如无包装规格可传1，生成订单的包装规格会按下单数量/包装规格，取最大能除尽的规格
        @JSONField(name = "deliver_num")
        private int deliverNum;//发货数量
    }


    @Data
    static class ChildOrder {
        @JSONField(name = "child_order_id")
        private String childOrderId;   //商品子订单号
        @JSONField(name = "order_status")
        private String orderStatus;   // 订单状态：1.待支付 2.待确认 3.待推送 4.待发货 5.待收货 6已收货 7.已完成 8.已取消
        @JSONField(name = "tax_amount")
        private String taxAmount;   // 税费（单位：元，保留两位小数）
        @JSONField(name = "pay_amount")
        private String payAmount;   // 支付金额（单位：元，保留两位小数）
        @JSONField(name = "tax_difference")
        private String taxDifference;   // 税差（单位：元，保留两位小数）
        @JSONField(name = "freight_amount")
        private String freightAmount;   // 运费（单位：元，保留两位小数）
        @JSONField(name = "sku_list")
        private List<XingYunPushOrderReqV2.Sku> skuList;   // 商品数组
    }


}
