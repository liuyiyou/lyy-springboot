package cn.liuyiyou.springboot.json;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

class DateTimeTest {

  private static final DateTimeFormatter ISOFormatter =
      DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").withZone(ZoneId.of("Asia/Shanghai"));

  @Test
  void instant() {
    System.out.println(Instant.now().atZone(ZoneId.systemDefault()).format(DateTimeFormatter.BASIC_ISO_DATE));


    System.out.println(Instant.now());


    System.out.println(Instant.now().atZone(ZoneId.systemDefault()).format(ISOFormatter));
  }

}
