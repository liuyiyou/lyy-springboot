package cn.liuyiyou.boot.temp;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: liuyiyou.cn
 * @date: 2020/9/25
 * @version: V1.0
 */
public class MapTest {



    public void putIfAbsentSet(){
        Map<String,Integer>  map = new HashMap<>();
        map.putIfAbsent("aaa",1);

    }

}
