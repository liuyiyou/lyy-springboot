package cn.liuyiyou.boot.temp;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: liuyiyou.cn
 * @date: 2020/12/13
 * @version: V1.0
 */
public class MapSort {

    public static void main(String[] args) {
        Map<String, Object> mapKey = new HashMap<>();
        Map<String, String> mapValue = new HashMap<>();
        mapValue.put("vc", "vc");
        mapValue.put("va", "va");
        mapValue.put("vb", "vb");
        mapKey.put("a", mapValue);
        Map<String, String> mapValue2 = new HashMap<>();
        mapValue2.put("vc", "vc");
        mapValue2.put("vb", "vb");
        mapValue2.put("va", "va");
        mapKey.put("c", mapValue2);
        mapKey.put("b", "b");
        String s = "{\"merchant_order_id\":\"zy2001969911\",\"sign\":\"291638b30b26b507fd5b6cb55c043831\",\"generate_fail_type\":12,\"merchant_id\":\"2020092306791352\",\"ret_msg\":\"没有可选批次\",\"is_success\":2,\"notice_code\":\"generate_order_notice\",\"error_sku_list\":[{\"buy_num\":1,\"channel_discount_amount\":\"0.00\",\"package_num\":0,\"price_type\":1,\"sku_code\":\"MZCZKH00018030-Z\",\"sku_discount_amount\":\"0.00\",\"sku_pay_amount\":\"149.00\",\"sku_price\":\"258.0\",\"sku_tax_amount\":\"0.00\"}],\"ret_code\":\"100130\",\"sign_type\":\"MD5\",\"order_id\":\"Z6077672009640562\"}";

//        Response response = JSONObject.parseObject(s,Response.class);
//        System.out.println(genMD5Sign(response, "1EISFBIU70057205A8C000008ECC5909"));
        final JSONObject jsonObject = JSONObject.parseObject(s);
        sign(jsonObject);

    }

    public static void sign(JSONObject jObject) {

        List<String> keyList = new ArrayList(jObject.keySet());
        Collections.sort(keyList);
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < keyList.size(); i++) {
            String key = keyList.get(i);
            Object value = jObject.get(key);
            if(value instanceof JSONArray){
                JSONArray jsonArray =(JSONArray)value;
                jsonArray.sort(Comparator.comparing(obj-> (String)obj));
            }
            sb.append(key + "=" + value + "&");
        }

          System.out.println(sb.toString());

    }
}
