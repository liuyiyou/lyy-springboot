package cn.liuyiyou.boot.temp;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.annotation.JSONType;
import java.io.Serializable;
import java.util.List;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author: liuyiyou.cn
 * @date: 2020/5/10
 * @version: V1.0
 */
@Data
@Accessors(chain = true)
public class XingYunPushOrderReq implements Serializable {
  public static final String PAY_TYPE_BALANCE = "1";
  @JSONField(name = "merchant_order_no")
  private String merchantOrderNo;//订单标识Id(一般是对接方的订单号),必传
  @JSONField(name = "opcode")
  private String opCode;//操作码，固定值: add_order,必传
  @JSONField(name = "pay_type")
  private String payType;//付款方式:1余额支付,2信用支付,必传
  @JSONField(name = "merchant_id")
  private String merchantId;//商户id,必传
  @JSONField(name = "accept_name")
  private String acceptName;//收货人姓名,必传
  @JSONField(name = "card_id")
  private String cardId;//身份证号码,必传
  @JSONField(name = "post_code")
  private String postCode;//邮政编码,必传
  @JSONField(name = "telphone")
  private String telphone;//联系电话,可不传
  @JSONField(name = "mobile")
  private String mobile;//手机,必传
  @JSONField(name = "province")
  private String province;//省,必传
  @JSONField(name = "city")
  private String city;//市,必传
  @JSONField(name = "area")
  private String area;//区,必传
  @JSONField(name = "address")
  private String address;//收货地址,必传
  @JSONField(name = "card_url_front")
  private String cardUrlFront;//身份证正面URL部分直邮必填,可不传
  @JSONField(name = "card_url_back")
  private String cardUrlBack;//身份证背面URL部分直邮必填,可不传
  @JSONField(name = "message")
  private String message;//订单留言,可不传
  @JSONField(name = "items")
  private List<Item> items;//必传
  @JSONField(name = "sign")
  private String sign;//MD5加密串,必传
  @JSONField(name = "sign_type")
  private String signType;//加密方式:MD5(大写),必传

  @Data
//  @JSONType(orders = {"merchant_order_no","quantity","sku_id"})
  static class Item implements Serializable {

    @JSONField(name = "merchant_order_no")
    private String merchantOrderNo;//订单标识Id(一般是对接方的订单号),必传
    @JSONField(name = "quantity")
    private Integer quantity;//订购数量,必传
    @JSONField(name = "sku_id")
    private String skuId;//商品编码(SKU_ID),必传


  }
}