package cn.liuyiyou.boot.temp.date;

import java.time.LocalDate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author: liuyiyou.cn
 * @date: 2021/3/1
 * @version: V1.0
 */
public class LocalDateExample {


    @Test
    @DisplayName("LocalDate只包含年月日")
    void  example_01(){
        LocalDate today = LocalDate.now();
        System.out.println("今天的日期:"+today);
    }

    @Test
    @DisplayName("LocalDate获取年月日")
    void  example_02(){
        LocalDate today = LocalDate.now();
        today.getDayOfYear();
    }
}
