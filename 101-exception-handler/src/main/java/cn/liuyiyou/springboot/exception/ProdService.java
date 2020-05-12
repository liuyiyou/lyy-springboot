package cn.liuyiyou.springboot.exception;

import cn.liuyiyou.springboot.exception.exception.BusiException;
import org.springframework.stereotype.Service;

/**
 * @author: liuyiyou.cn
 * @date: 2020/5/12
 * @version: V1.0
 */
@Service
public class ProdService {

  public Prod findById(Integer id) {
    Prod prod = new Prod();
    if (id.equals(1)) {
      return prod;
    } else {
      throw new BusiException(String.format("prod.id=%s 不存在", 1));
    }
  }
}
