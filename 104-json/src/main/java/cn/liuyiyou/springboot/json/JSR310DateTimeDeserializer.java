package cn.liuyiyou.springboot.json;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import java.io.IOException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;

/**
 * @author: liuyiyou.cn
 * @date: 2020/9/22
 * @version: V1.0
 */
public final class JSR310DateTimeDeserializer extends JsonDeserializer<Instant> {

    private static final DateTimeFormatter ISOFormatter =
        DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").withZone(ZoneId.of("Asia/Shanghai"));

    private static final DateTimeFormatter ISO_DATE_OPTIONAL_TIME;

    //
    static {
        ISO_DATE_OPTIONAL_TIME = new DateTimeFormatterBuilder()
            .append(DateTimeFormatter.ISO_LOCAL_DATE)
            .optionalStart()
            .appendLiteral('T')
            .append(DateTimeFormatter.ISO_OFFSET_TIME)
            .toFormatter();
    }

    //
    public static final JSR310DateTimeDeserializer INSTANCE = new JSR310DateTimeDeserializer();
//
//    private JSR310DateTimeDeserializer() {
//
//    }
//
//    @Override
//    public TemporalAccessor deserialize(final JsonParser p, final DeserializationContext ctxt)
//        throws IOException, JsonProcessingException {
//        return  null;
//    }


    @Override
    public Instant deserialize(final JsonParser parser, final DeserializationContext ctxt)
        throws IOException, JsonProcessingException {

        switch (parser.getCurrentToken()) {
            case START_ARRAY:
//                if (parser.nextToken() == JsonToken.END_ARRAY) {
//                    return null;
//                }
//                int year = parser.getIntValue();
//
//                parser.nextToken();
//                int month = parser.getIntValue();
//
//                parser.nextToken();
//                int day = parser.getIntValue();
//
//                if (parser.nextToken() != JsonToken.END_ARRAY) {
//                    throw ctxt
//                        .wrongTokenException(parser, JsonToken.END_ARRAY, "Expected array to end.");
//                }
//
//                 LocalDate.of(year, month, day);
                throw ctxt
                    .wrongTokenException(parser, JsonToken.START_ARRAY,
                        "Expected array or string.");
            case VALUE_STRING:
                String string = parser.getText().trim();
                if (string.length() == 0) {
                    return null;
                }
                if (string.contains("T")) {
                    return Instant.parse(string);
                }
                final LocalDateTime parse = LocalDateTime.parse(string, ISOFormatter);
                return parse.atZone(ZoneId.systemDefault()).toInstant();
        }
        throw ctxt
            .wrongTokenException(parser, JsonToken.START_ARRAY, "Expected array or string.");
    }
}
