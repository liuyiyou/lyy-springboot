package cn.liuyiyou.boot.temp;

import org.junit.jupiter.api.Test;

/**
 * @author: liuyiyou.cn
 * @date: 2020/6/17
 * @version: V1.0
 */
public class FloatTest {


  @Test
  public void test(){
    Float value = 1.23F;
    final String s = String.valueOf((int)(value * 100));
    System.out.println(s);
  }

}
