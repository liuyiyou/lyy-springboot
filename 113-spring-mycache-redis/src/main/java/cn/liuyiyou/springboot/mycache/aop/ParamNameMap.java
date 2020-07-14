package cn.liuyiyou.springboot.mycache.aop;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author: liuyiyou.cn
 * @date: 2020/7/14
 * @version: V1.0
 */
public class ParamNameMap {

  private static ConcurrentHashMap<String, String[]> map = new ConcurrentHashMap<String, String[]>();

  public static void put(String key, String[] paramNames) {
    map.putIfAbsent(key, paramNames);
  }

  public static String[] get(String key) {
    return map.get(key);
  }
}
