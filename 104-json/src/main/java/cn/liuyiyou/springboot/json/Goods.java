package cn.liuyiyou.springboot.json;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author: liuyiyou.cn
 * @date: 2020/6/9
 * @version: V1.0
 */
@Data
@Accessors(chain = true)
public class Goods implements Serializable {

  private Integer id;
  private String name;
  @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
  private LocalDateTime createTime;

  private Date updateTime;
}
