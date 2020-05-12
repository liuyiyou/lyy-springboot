package cn.liuyiyou.boot.temp;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.Feature;
import java.util.LinkedHashMap;
import org.junit.jupiter.api.Test;

/**
 * @author: liuyiyou.cn
 * @date: 2020/5/10
 * @version: V1.0
 */
public class JSONTest {

  /**
   * 需求如下，有如下对象，其中Items中的对象是无序的。怎样才能有序呢？
   * <code>
   * <pre>
   *     {
   *     "accept_name":"袁莺英",
   *     "address":"她她她",
   *     "area":"重庆市",
   *     "card_id":"320211195505271349",
   *     "city":"重庆市",
   *     "items":[
   *         {
   *             "merchant_order_no":"zy2010000051345",
   *             "quantity":1,
   *             "sku_id":"MBS00002-B"
   *         }
   *     ],
   *     "merchant_id":"75041628",
   *     "mobile":"13016313593",
   *     "opcode":"add_order",
   *     "pay_type":"1",
   *     "post_code":"400030",
   *     "province":"重庆市",
   *     "sign":"2c39e6e6337d3e0b751820fbbb625b58",
   *     "sign_type":"MD5"
   * }
   *   </pre>
   * </code>
   */
  @Test
  public void sort() {
    String jsonStr = "{\"accept_name\":\"袁莺英\",\"address\":\"她她她\",\"area\":\"重庆市\",\"card_id\":\"320211195505271349\",\"city\":\"重庆市\",\"items\":[{\"quantity\":1,\"sku_id\":\"MBS00002-B\",\"merchant_order_no\":\"zy2010000051345\"}],\"merchant_id\":\"75041628\",\"mobile\":\"13016313593\",\"opcode\":\"add_order\",\"pay_type\":\"1\",\"post_code\":\"400030\",\"province\":\"重庆市\"}";
    XingYunPushOrderReq xingYunPushOrderReq = JSONObject
        .parseObject(jsonStr, XingYunPushOrderReq.class);
    String s = JSON.toJSONString(xingYunPushOrderReq);
    System.out.println(s);
    final LinkedHashMap linkedHashMap = JSON
        .parseObject(s, LinkedHashMap.class, Feature.OrderedField);
    StringBuilder prestr = new StringBuilder();
    linkedHashMap.forEach((key,value)-> prestr.append(key).append("=").append(value).append("&"));
    prestr.deleteCharAt(prestr.length()-1);
    String source = prestr.toString().replaceAll("\"", "") ;
    System.out.println(source);
  }

}
