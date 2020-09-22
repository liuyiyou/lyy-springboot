package cn.liuyiyou.springboot.json;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;
import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * @author: liuyiyou.cn
 * @date: 2020/6/9
 * @version: V1.0
 */
@Data
@Accessors(chain = true)
@ToString
public class Goods implements Serializable {

    private Integer id;
    private String name;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime localDateTimeFormat;

    //Resolved [org.springframework.http.converter.HttpMessageNotWritableException: Could not write JSON: Unsupported field: YearOfEra; nested exception is com.fasterxml.jackson.databind.JsonMappingException: Unsupported field: YearOfEra (through reference chain: cn.liuyiyou.springboot.json.Goods["instantFormat"])]
//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Instant instantFormat;

    private Date dateFormat;

    private Date date;

    private LocalDateTime localDateTime;

    private Instant instant;
}
