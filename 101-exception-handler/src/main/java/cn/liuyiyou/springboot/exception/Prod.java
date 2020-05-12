package cn.liuyiyou.springboot.exception;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author: liuyiyou.cn
 * @date: 2020/5/12
 * @version: V1.0
 */
@Data
@Accessors(chain = true)
public class Prod {

  private Integer id;
  private String name;
}
