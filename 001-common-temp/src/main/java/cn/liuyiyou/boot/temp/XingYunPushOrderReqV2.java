package cn.liuyiyou.boot.temp;

import com.alibaba.fastjson.annotation.JSONField;
import java.io.Serializable;
import java.util.List;
import lombok.Data;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;

/**
 * 天行云2.0订单请求
 */
@Data
@Accessors(chain = true)
@Slf4j
public class XingYunPushOrderReqV2 implements Serializable {

    //订单类型 1.保税订单，2.非保税订单
    public static final int ORDER_TYPE_BONDED = 1;
    public static final int ORDER_TYPE_NON_BONDED = 2;

    //三单对碰推单方式（1.代推订单和运单，2.代推运单）【保税订单必填】
    public static final int PUSH_TYPE_ORDER_FREIGHT = 1;
    public static final int PUSH_TYPE_ONLY_FREIGHT = 2;

    //渠道价格类型（1含税，2不含税）【非保税默认为含税】
    public static final int PRICE_TYPE_TAX_INCLUDED = 1;
    public static final int PRICE_TYPE_TAX_NO_INCLUDED = 2;

    @JSONField(name = "opcode")
    private String opCode;//操作码，固定值: ,必传
    @JSONField(name = "sign")
    private String sign;//MD5加密串,必传
    @JSONField(name = "sign_type")
    private String signType;//加密方式:MD5(大写),必传
    @JSONField(name = "merchant_id")
    private String merchantId;//商户id,必传
    @JSONField(name = "order_type")
    private Integer orderType;//  订单类型 1.保税订单，2.非保税订单  ,必传
    @JSONField(name = "push_type")
    private Integer pushType;//  三单对碰推单方式（1.代推订单和运单，2.代推运单）【保税订单必填】
    @JSONField(name = "merchant_order_id")
    private String merchantOrderId;   //  商家订单号,必传
    @JSONField(name = "pay_type")
    private Integer payType;//付款方式:1余额支付,2信用支付,必传
    @JSONField(name = "buyer_name")
    private String buyerName;   // 订购人姓名【保税订单则为必填项】
    @JSONField(name = "buyer_card_id")
    private String buyerCardId;   // 订购人身份证号码【保税订单则为必填项】
    @JSONField(name = "recipient_name")
    private String recipientName;   // 收货人姓名 必传
    @JSONField(name = "recipient_card_id")
    private String recipientCardId;   // 收货人身份号码【保税或直邮为必填项】
    @JSONField(name = "recipient_mobile")
    private String recipientMobile;   // 收货人手机号  必传
    @JSONField(name = "order_province")
    private String orderProvince;   // 所属区域：省（中文）  必传
    @JSONField(name = "order_city")
    private String orderCity;   // 所属区域：市（中文） 必传
    @JSONField(name = "order_area")
    private String orderArea;   // 所属区域：区（中文）,当无第三级时不填
    @JSONField(name = "order_address")
    private String orderAddress;   // 收货详细地址  必传
    @JSONField(name = "card_front_url")
    private String cardFrontUrl;   // 订购人身份证正面URL【保税订单、部分直邮为必填】
    @JSONField(name = "card_back_url")
    private String cardBackUrl;   // 订购人身份证反面URL【保税订单、部分直邮为必填】
    @JSONField(name = "custom_pay_order")
    private String customPayOrder;   // 清关单号（推支付单时带的订单号）
    @JSONField(name = "order_time")
    private String orderTime;   // 下单时间(格式 yyyy-MM-dd HH:mm:ss) 【保税订单则为必填项】
    @JSONField(name = "pay_time")
    private String payTime;   // 支付时间(格式 yyyy-MM-dd HH:mm:ss) 【保税订单则为必填项】
    @JSONField(name = "third_pay_type")
    private Integer thirdPayType;//  支付方式：(1 支付宝,2 微信,3 商盟,4 汇付,5 通联,9 联动,10 云闪付,11 平安付,12 苏宁易付宝,13 银联,14 汇聚支付 15 新生支付 16 有赞支付 )【保税订单则为必填项】
    @JSONField(name = "pay_custom_no")
    private String payCustomNo;   // 支付公司编码 【保税订单则为必填项】
    @JSONField(name = "pay_company_name")
    private String payCompanyName;   // 支付公司名称 【保税订单则为必填项】
    @JSONField(name = "pay_third_no")
    private String payThirdNo;   // 交易流水号 【保税订单则为必填项】
    @JSONField(name = "sku_list")
    private List<Sku> skuList;   // 商品数组 签名前按字段名的字母顺序排序数组内字段 必传
    @JSONField(name = "order_pay_amount")
    private String orderPayAmount;//终端支付总金额,必传
    @JSONField(name = "order_discount_amount")
    private String orderDiscountAmount;//平台优惠总金额(单位：元，保留两位小数)
    @JSONField(name = "channel_discount_amount")
    private String channelDiscountAmount;//	渠道优惠总金额(单位：元，保留两位小数)  必传
    @JSONField(name = "order_freight_amount")
    private String orderFreightAmount;//	运费总金额(单位：元，保留两位小数)） 必传
    @JSONField(name = "remark")
    private String remark;//订单备注
    @JSONField(name = "order_total_amount")
    private String orderTotalAmount;//订单总金额 （单位元） 必传
    @JSONField(name = "ecommerce_name")
    private String ecommerceName;//电商平台名称(保税下单必填)
    @JSONField(name = "ecommerce_code")
    private String ecommerceCode;//电商平台海关编码(保税下单必填)


    //查询订单使用
    @JSONField(name = "order_id")
    private String orderId;//	行云订单号

    //查询skuprice使用
    @JSONField(name = "sku_code")
    private String skuCode;//	SKU编码


    @Data
    static class Sku implements Serializable {

        @JSONField(name = "sku_code")
        private String skuCode;//商品编码（sku_code）, 必传
        @JSONField(name = "package_num")
        private String packageNum;//包装规格【如无匹配包装规格可传0，生成订单的包装规格会按下单数量/包装规格，取最大能除尽的规格, 必传
        @JSONField(name = "buy_num")
        private String buyNum;//购买数量,必传
        @JSONField(name = "sku_price")
        private String skuPrice;//渠道售价(单位：元，保留两位小数),必传
        @JSONField(name = "sku_tax_amount")
        private String skuTaxAmount;//综合税费(单位：元，保留两位小数)
        @JSONField(name = "sku_discount_amount")
        private String skuDiscountAmount;//平台优惠金额(单位：元，保留两位小数)）
        @JSONField(name = "channel_discount_amount")
        private String channelDiscountAmount;//渠道优惠金额,必传
        @JSONField(name = "sku_pay_amount")
        private String skuPayAmount;//终端支付金额(单位：元，保留两位小数),必传
        @JSONField(name = "price_type")
        private Integer priceType;//渠道价格类型（1含税，2不含税）【非保税默认为含税】


        // 通知回调用到这两个
        @JSONField(name = "sku_tax_rate")
        private String skuTaxRate;//综合税率(小数))
        @JSONField(name = "sku_tax_difference")
        private String skuTaxDifference;//综合税差(单位：元，保留两位小数)


        //拆单使用到
        private String orderId;

    }

    @Data
    static class PayInfo {

        private Integer thirdPayType;
        private String payCustomRecord;
        private String payCompany;
    }

    @Data
    static class Content {

        private String content;
        private String name;
    }

}
