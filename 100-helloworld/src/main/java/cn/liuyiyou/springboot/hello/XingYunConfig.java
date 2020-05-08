package cn.liuyiyou.springboot.hello;

import cn.hutool.http.HttpRequest;
import cn.hutool.json.JSONUtil;
import java.io.UnsupportedEncodingException;
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

  private static String uri = "http://openapi.xyb2b.com";

  public static String merch = "2019082160892137";

  public static String privateKey = "1DIPDEFCE0003900A8C00000CF4C2427";

  public static void main(String[] args) {
    getSubsStatus();
  }

  public static void getSubsStatus() {
    String url = uri + "/api/service/business";
    Map<String, Object> param = new HashMap<>();
    param.put("opcode", "get_order_info");
    param.put("merchant_id", merch);
    param.put("order_no", "O35888533432492836");
    param.put("sign_type", "MD5");
    param.put("sign", sign(param));
    System.out.println(JSONUtil.parse(param));
    String body = HttpRequest.post(url).header("Content-Type", "application/json")
        .body(JSONUtil.parse(param)).execute().body();
    log.info(body);

  }

  public static String sign(Map<String, Object> params) {
    TreeMap<String, Object> stringObjectTreeMap = new TreeMap<>(params);
    String s = null;
    StringBuilder paramrBuilder = new StringBuilder();
    for (String key : stringObjectTreeMap.keySet()) {
      if (!"sign".equals(key)  && !"sign_type".equalsIgnoreCase(key)) {
        paramrBuilder.append(key).append("=").append(params.get(key)).append("&");
      }
    }
    paramrBuilder.deleteCharAt(paramrBuilder.length()-1);
    paramrBuilder.append(privateKey);
    System.out.println(paramrBuilder.toString());
    try {
      s = DigestUtils.md5DigestAsHex(paramrBuilder.toString().getBytes("UTF-8"));
    } catch (UnsupportedEncodingException e) {
      e.printStackTrace();
    }
    return s;
  }
}
