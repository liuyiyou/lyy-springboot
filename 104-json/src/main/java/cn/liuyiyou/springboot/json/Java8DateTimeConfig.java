package cn.liuyiyou.springboot.json;

import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.InstantSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalTimeSerializer;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
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
            JavaTimeModule module = new JavaTimeModule();
            module.addSerializer(LocalDateTime.class, new LocalDateTimeSerializer(DateTimeFormatter.ofPattern(dateTimeFormat)));
            module.addDeserializer(LocalDateTime.class, new LocalDateTimeDeserializer(DateTimeFormatter.ofPattern(dateTimeFormat)));

            module.addSerializer(LocalTime.class, new LocalTimeSerializer(DateTimeFormatter.ofPattern(dateTimeFormat)));
            module.addDeserializer(LocalTime.class, new LocalTimeDeserializer(DateTimeFormatter.ofPattern(dateTimeFormat)));

            module.addSerializer(LocalDate.class, new LocalDateSerializer(DateTimeFormatter.ofPattern(dateFormat)));
            module.addDeserializer(LocalDate.class, new LocalDateDeserializer(DateTimeFormatter.ofPattern(dateFormat)));


//            module.addSerializer(Instant.class, JSR310DateTimeSerializer.INSTANCE);
//            module.addDeserializer(Instant.class, JSR310DateTimeDeserializer.INSTANCE);

            //Goods(id=1, name=手机, localDateTimeFormat=2020-09-22T17:51:38, instantFormat=null, dateFormat=Tue Sep 22 17:51:38 CST 2020, date=Tue Sep 22 17:51:38 CST 2020, localDateTime=2020-09-22T17:51:38, instant=null)
            module.addSerializer(Instant.class, CustomInstantSerializer.INSTANCE);
            module.addDeserializer(Instant.class, CustomInstantDeserializer.INSTANCE);

            builder.modulesToInstall(module);



        };
    }


    public static void main(String[] args) {
        final InstantSerializer instance = InstantSerializer.INSTANCE;
    }
}
