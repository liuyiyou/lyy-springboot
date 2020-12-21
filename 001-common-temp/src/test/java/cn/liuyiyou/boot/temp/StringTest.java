package cn.liuyiyou.boot.temp;

import java.io.UnsupportedEncodingException;
import org.junit.jupiter.api.Test;

/**
 * @author: liuyiyou.cn
 * @date: 2020/12/20
 * @version: V1.0
 */
public class StringTest {

    @Test
    public void  testStrLeng() throws UnsupportedEncodingException {
        String skuNameStr = "朵依妍 羽绒棉服短款加厚羽绒棉服 加厚小个子外套 连帽大毛领 修身显瘦 三色多尺码可选 M,白色";
        System.out.println(skuNameStr.length());
        int length = skuNameStr.getBytes("utf-8").length;
        String subject = length >= 128 ? skuNameStr.substring(0, 30) : skuNameStr;
        System.out.println(subject);
    }
}
