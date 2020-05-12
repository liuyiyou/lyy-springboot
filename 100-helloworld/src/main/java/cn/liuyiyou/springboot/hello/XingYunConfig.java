package cn.liuyiyou.springboot.hello;

import cn.hutool.http.HttpRequest;
import cn.hutool.json.JSONUtil;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.DigestUtils;

/**
 * @author: liuyiyou.cn
 * @date: 2020/5/8
 * @version: V1.0
 */
@Slf4j
public class XingYunConfig {

  private static String uri = "http://120.76.191.121:81";//http://openapi.xyb2b.com";

  public static String merch = "75041628";//"2019082160892137";

  public static String privateKey = "1BG847AC10007300A8C000000F634ED6";//"1DIPDEFCE0003900A8C00000CF4C2427";

  public static void main(String[] args) {
//    getSubsStatus();
//    String str = "accept_name=袁莺英&address=她她她&area=重庆市&card_id=320211195505271349&city=重庆市&items=[{\"quantity\":1,\"sku_id\":\"MBS00002-B\",\"merchant_order_no\":\"zy2010000051345\"}]&merchant_id=75041628&mobile=13016313593&opcode=add_order&pay_type=1&post_code=400030&province=重庆市1BG847AC10007300A8C000000F634ED6";
//    final String s = DigestUtils.md5DigestAsHex(str.getBytes(StandardCharsets.UTF_8));
//    System.out.println(s.equals("93d65e4cdaa2b8f9a43dc6483784aba0"));
    createOrder();
  }

  public static void  createOrder(){
    String url = uri + "/api/service/business";
    Map<String, Object> param = new HashMap<>();
//    param.put("merchant_order_no", "zy2010000051345");
    param.put("accept_name", "袁莺英");
    param.put("address", "她她她");
    param.put("area", "重庆市");
    param.put("card_id", "320211195505271349");
    param.put("city", "重庆市");
    param.put("items", "[{\"merchant_order_no\":\"zy2010000051345-B\",\"quantity\":1,\"sku_id\":\"MBS00002-B\"}]");
//    param.put("items", "[{quantity:1,sku_id:MBS00002-B,merchant_order_no:zy2010000051345}]");
    param.put("mobile", "13016313593");
    param.put("opcode", "add_order");
    param.put("pay_type", "1");
    param.put("order_no", "O15834018943291911");
    param.put("post_code", "400030");
    param.put("province", "重庆市");
    param.put("merchant_id", merch);
    param.put("sign_type", "MD5");
    param.put("sign", sign(param));
    System.out.println(JSONUtil.parse(param));
    String body = HttpRequest.post(url).header("Content-Type", "application/json")
        .body(JSONUtil.parse(param)).execute().body();
    log.info(body);
  }

  public static void getSubsStatus() {
    String url = uri + "/api/service/business";
    Map<String, Object> param = new HashMap<>();
    param.put("opcode", "get_order_info");
    param.put("merchant_id", merch);
    param.put("order_no", "O15834018943291911");
    param.put("sign_type", "MD5");
    param.put("sign", sign(param));
    String body = HttpRequest.post(url).header("Content-Type", "application/json")
        .body(JSONUtil.parse(param)).execute().body();
    log.info(body);

  }

  public static String sign(Map<String, Object> params) {
    TreeMap<String, Object> stringObjectTreeMap = new TreeMap<>(params);
    StringBuilder paramrBuilder = new StringBuilder();
    for (String key : stringObjectTreeMap.keySet()) {
      if (!"sign".equals(key) && !"sign_type".equalsIgnoreCase(key)) {
        paramrBuilder.append(key).append("=").append(params.get(key)).append("&");
      }
    }
    paramrBuilder.deleteCharAt(paramrBuilder.length() - 1);
    paramrBuilder.append(privateKey);
    String source = paramrBuilder.toString().replaceAll("\"", "");
    System.out.println(source);
    return DigestUtils.md5DigestAsHex(source.getBytes(StandardCharsets.UTF_8));
  }
}
