package cn.liuyiyou.boot.temp;

import static com.alibaba.fastjson.JSON.parseObject;
import static org.apache.commons.codec.digest.DigestUtils.md5Hex;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.Feature;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author: liuyiyou.cn
 * @date: 2020/12/13
 * @version: V1.0
 */
public class MD5Check {

    public static void main(String[] args) {
//        String s = "{\"merchant_order_id\":\"zy2001969911\",\"sign\":\"291638b30b26b507fd5b6cb55c043831\",\"generate_fail_type\":12,\"merchant_id\":\"2020092306791352\",\"ret_msg\":\"没有可选批次\",\"is_success\":2,\"notice_code\":\"generate_order_notice\",\"error_sku_list\":[{\"buy_num\":1,\"channel_discount_amount\":\"0.00\",\"package_num\":0,\"price_type\":1,\"sku_code\":\"MZCZKH00018030-Z\",\"sku_discount_amount\":\"0.00\",\"sku_pay_amount\":\"149.00\",\"sku_price\":\"258.0\",\"sku_tax_amount\":\"0.00\"}],\"ret_code\":\"100130\",\"sign_type\":\"MD5\",\"order_id\":\"Z6077672009640562\"}";
//
////        Response response = JSONObject.parseObject(s,Response.class);
////        System.out.println(genMD5Sign(response, "1EISFBIU70057205A8C000008ECC5909"));
//        final JSONObject jsonObject = JSONObject.parseObject(s);
//        System.out.println(genMD5Sign(jsonObject, "1EISFBIU70057205A8C000008ECC5909"));

        String s2 = "{\"notice_code\":\"deliver_order_notice\",\"merchant_order_id\":\"12121320414\",\"sign\":\"d52f73268d7a90fbdbabe3b56505c25f\",\"ret_msg\":\"处理成功\",\"ret_code\":\"200\",\"sign_type\":\"MD5\",\"order_id\":\"XS6077384042602548\",\"biz_order_id\":\"F6077609513482605\",\"express_list\":[{\"express_code\":\"yunda\",\"express_company\":\"韵达快递\",\"express_order\":\"7700190387995\",\"sku_list\":[{\"deliver_num\":1,\"package_num\":1,\"sku_code\":\"MZGHHSS00002213-Z\"}]}]}";

        final Reponse2 reponse2 = JSONObject.parseObject(s2, Reponse2.class);
        System.out.println(genMD5Sign(reponse2, "1EISFBIU70057205A8C000008ECC5909"));
    }

    public static String genMD5Sign2(Object object, String secretKey) {
        StringBuilder prestr = new StringBuilder();
        Map linkedHashMap = parseObject(JSONObject.toJSONString(object), LinkedHashMap.class, Feature.OrderedField);
        final Set set1 = linkedHashMap.keySet();
        List<String> keyList = new ArrayList(set1);
        keyList.sort(Comparator.naturalOrder());
        keyList.forEach(k -> {
            if (!k.equalsIgnoreCase("sign") && !k.equalsIgnoreCase("sign_type") && !k.equalsIgnoreCase("signType")) {
                Object v = linkedHashMap.get(k);
                prestr.append(k).append("=");
                if (v instanceof JSONArray) {
                    List<LinkedHashMap> mapList = ((JSONArray) v).toJavaList(LinkedHashMap.class);
                    List<LinkedHashMap> mapList2 = new LinkedList<>();
                    for (LinkedHashMap linkedHashMap1 : mapList) {
                        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                        final Set set = linkedHashMap1.keySet();
                        List list = new ArrayList(set);
                        list.sort(Comparator.naturalOrder());
                        for (Object key : list) {
                            final Object o = linkedHashMap1.get(key);
                            if (o instanceof JSONArray) {
//                                prestr.append(key).append(":").append(orderMap(o));
                                linkedHashMap2.put(key, orderMap(o));
                            } else {
                                linkedHashMap2.put(key, o);
                            }

                        }
                        mapList2.add(linkedHashMap2);
                    }
                    System.out.println(JSON.toJSON(mapList2).toString().replaceAll("\\\\", ""));
                    prestr.append(JSON.toJSON(mapList2).toString().replaceAll("\\\\", ""));
                } else {
                    prestr.append(v);
                }
                prestr.append("&");
            }
        });
        prestr.deleteCharAt(prestr.length() - 1);
        String source = prestr.append(secretKey).toString();
        System.out.println(source);
        return md5Hex(source);
    }

    public static String orderMap(Object v) {
        if (v instanceof JSONArray) {
            List<LinkedHashMap> mapList = ((JSONArray) v).toJavaList(LinkedHashMap.class);
            List<JSONObject> mapList2 = new LinkedList<>();
            for (LinkedHashMap linkedHashMap1 : mapList) {
                JSONObject linkedHashMap2 = new JSONObject();
                final Set set = linkedHashMap1.keySet();
                List list = new ArrayList(set);
                list.sort(Comparator.naturalOrder());
                for (Object key : list) {
                    final Object o = linkedHashMap1.get(key);
                    linkedHashMap2.put((String) key, o);
                }
                mapList2.add(linkedHashMap2);
            }
            String s = JSON.toJSONString(mapList2);
            System.out.println(s);
            return s;
        }
        return "";
    }

    public static String genMD5Sign(Object object, String secretKey) {
        Map<String,Object> linkedHashMap = parseObject(JSONObject.toJSONString(object), LinkedHashMap.class, Feature.OrderedField);
        StringBuilder prestr = new StringBuilder();
        linkedHashMap.forEach((key, value) -> {
            if (!key.equalsIgnoreCase("sign") && !key.equalsIgnoreCase("sign_type") && !key.equalsIgnoreCase("signType")) {
                prestr.append(key).append("=").append(value).append("&");
            }
        });
        prestr.deleteCharAt(prestr.length() - 1);
        System.out.println(prestr.toString());
        String source = prestr.append(secretKey).toString().replaceAll("\"", "");
        return md5Hex(source);
    }

    public static String genMD5Sign(JSONObject object, String secretKey) {
        Map<String, Object> map = parseObject(object.toJSONString(), Map.class);
        Set<String> strings = map.keySet();
        List<String> keyList = new ArrayList<>(strings);
        keyList.sort(Comparator.naturalOrder());
        StringBuilder prestr = new StringBuilder();
        for (String key : keyList) {
            if (!key.equalsIgnoreCase("sign") && !key.equalsIgnoreCase("sign_type") && !key.equalsIgnoreCase("signType")) {
                final Object o = map.get(key);
                if (o instanceof JSONArray) {
                    prestr.append(key).append("=");
                    JSONArray jsonArray = (JSONArray) o;
                    for (int i = 0; i < jsonArray.size(); i++) {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        LinkedHashMap linkedHashMap = new LinkedHashMap();
                        Map<String, Object> valueMap = parseObject(jsonObject.toJSONString(), Map.class);
                        Set<String> valueStrings = valueMap.keySet();
                        List<String> valueKeyList = new ArrayList<>(valueStrings);
                        valueKeyList.sort(Comparator.naturalOrder());
                        for (String valueKey : valueKeyList) {
                            final Object o1 = jsonObject.get(valueKey);
                            if (o1 instanceof JSONArray) {
                                JSONArray jsonArray1 = (JSONArray) o1;
                                LinkedHashMap linkedHashMap1 = new LinkedHashMap();
                                for (int j = 0; j < jsonArray1.size(); j++) {
                                    JSONObject jsonObject1 = jsonArray1.getJSONObject(j);
                                    Map<String, Object> valueMap1 = parseObject(jsonObject1.toJSONString(), Map.class);
                                    Set<String> valueStrings1 = valueMap1.keySet();
                                    List<String> valueKeyList1 = new ArrayList<>(valueStrings1);
                                    valueKeyList1.sort(Comparator.naturalOrder());
                                    for (String valueKey1 : valueKeyList1) {
                                        final Object o2 = jsonObject1.get(valueKey1);
                                        linkedHashMap1.put(valueKey1, o2);
                                        jsonArray1.add(linkedHashMap);
                                    }
                                }
                                linkedHashMap.put(valueKey, jsonArray1);
                            } else {
                                linkedHashMap.put(valueKey, o1);
                            }
                        }
                        prestr.append("[" + JSONObject.toJSONString(linkedHashMap) + "]").append("&");
                    }
                } else {
                    prestr.append(key).append("=").append(map.get(key)).append("&");
                }
            }
        }
        prestr.deleteCharAt(prestr.length() - 1);
        String source = prestr.append(secretKey).toString().replaceAll("\"", "");
        System.out.println(source);
        return md5Hex(source);
    }


}
