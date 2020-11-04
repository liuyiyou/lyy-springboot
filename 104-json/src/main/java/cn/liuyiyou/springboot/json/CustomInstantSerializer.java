package cn.liuyiyou.springboot.json;

import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.fasterxml.jackson.datatype.jsr310.ser.InstantSerializerBase;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;

/**
 * @author: liuyiyou.cn
 * @date: 2020/9/22
 * @version: V1.0
 */
public class CustomInstantSerializer extends InstantSerializerBase<Instant> {

    private static final DateTimeFormatter ISOFormatter =
        DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").withZone(ZoneId.of("Asia/Shanghai"));

    public static CustomInstantSerializer INSTANCE = new CustomInstantSerializer();

    public CustomInstantSerializer() {
        super(Instant.class, Instant::toEpochMilli, Instant::getEpochSecond, Instant::getNano,
            ISOFormatter);
    }

    public CustomInstantSerializer(Class<Instant> supportedType,
        ToLongFunction<Instant> getEpochMillis,
        ToLongFunction<Instant> getEpochSeconds,
        ToIntFunction<Instant> getNanoseconds,
        DateTimeFormatter formatter) {
        super(supportedType, getEpochMillis, getEpochSeconds, getNanoseconds, formatter);
    }

    public CustomInstantSerializer(
        InstantSerializerBase<Instant> base, Boolean useTimestamp,
        DateTimeFormatter dtf) {
        super(base, useTimestamp, dtf);
    }

    public CustomInstantSerializer(
        InstantSerializerBase<Instant> base, Boolean useTimestamp,
        Boolean useNanoseconds,
        DateTimeFormatter dtf) {
        super(base, useTimestamp, useNanoseconds, dtf);
    }

    @Override
    protected InstantSerializerBase<?> withFormat(Boolean useTimestamp,
        DateTimeFormatter dtf, Shape shape) {
        return new CustomInstantSerializer(this, useTimestamp, ISOFormatter);
    }


}
