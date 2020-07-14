package cn.liuyiyou.boot.temp;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

/**
 * @author: liuyiyou.cn
 * @date: 2020/6/17
 * @version: V1.0
 */
public class FloatTest {


  @Test
  public void test() {
    Float value = 1.23F;
    final String s = String.valueOf((int) (value * 100));
    System.out.println(s);
  }

  @Test
  public void test2() {
    Float sum = 0.0F;
    List<Float> sums = Arrays.asList(19.9F, 999F);
    for (Float f : sums) {
      sum += f;
    }
    System.out.println(sum);

    String totalFee = "101890";
    BigDecimal sumSubsPayFeeRemote = new BigDecimal(totalFee);
    BigDecimal sumSubsPayFeeLocal = new BigDecimal(getFixFloat(sum, 2).toString())
        .multiply(new BigDecimal(100));
    System.out.println(sumSubsPayFeeRemote.longValue() == sumSubsPayFeeLocal.longValue());
  }

  public static Float getFixFloat(Float input, int fixNumber) {
    if (input == null) {
      return null;
    }
    //如果传入的是1.635f计算后，float后是1.63没达到四舍五入的效果,传入的是2.435又可以达到四舍五入的效果
//		BigDecimal b = new BigDecimal(input);
//		Float f1 = b.setScale(fixNumber, BigDecimal.ROUND_HALF_UP).floatValue();

    BigDecimal b = new BigDecimal(input.toString());
    Float f1 = b.setScale(fixNumber, BigDecimal.ROUND_HALF_UP).floatValue();

    return f1;
  }
}
