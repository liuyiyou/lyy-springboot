package cn.liuyiyou.springboot.json;

import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import java.time.format.DateTimeFormatter;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: liuyiyou.cn
 * @date: 2020/6/9
 * @version: V1.0
 */
@Configuration
public class Java8DateTimeConfig {

  private static final String dateFormat = "yyyy-MM-dd";
  private static final String dateTimeFormat = "yyyy-MM-dd HH:mm:ss";

  @Bean
  public Jackson2ObjectMapperBuilderCustomizer jsonCustomizer() {
    return builder -> {
      builder.simpleDateFormat(dateTimeFormat);
      builder.serializers(new LocalDateSerializer(DateTimeFormatter.ofPattern(dateFormat)));
      builder.serializers(new LocalDateTimeSerializer(DateTimeFormatter.ofPattern(dateTimeFormat)));
    };
  }
}
