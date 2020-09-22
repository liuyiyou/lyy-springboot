package cn.liuyiyou.springboot.json;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.io.IOException;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;

/**
 * @author: liuyiyou.cn
 * @date: 2020/9/22
 * @version: V1.0
 */
public final class JSR310DateTimeSerializer extends JsonSerializer<TemporalAccessor> {

    private static final DateTimeFormatter ISOFormatter =
        DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").withZone(ZoneId.of("Asia/Shanghai"));

    public static final JSR310DateTimeSerializer INSTANCE = new JSR310DateTimeSerializer();

    private JSR310DateTimeSerializer() {

    }

    @Override
    public void serialize(TemporalAccessor value, JsonGenerator generator,
        SerializerProvider serializerProvider) throws IOException {
        generator.writeString(ISOFormatter.format(value));
    }
}
