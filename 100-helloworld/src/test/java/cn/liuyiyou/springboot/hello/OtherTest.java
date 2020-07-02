package cn.liuyiyou.springboot.hello;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

/**
 * @author: liuyiyou.cn
 * @date: 2020/6/22
 * @version: V1.0
 */
public class OtherTest {



  @DisplayName("浮点比较判断")
  @Test
  public void floatTest(){
    float f = 222F;
    Integer i = 220;
    System.out.println(f==222);
  }

}
