package cn.liuyiyou.springboot.hello;

import cn.hutool.core.map.MapUtil;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: liuyiyou.cn
 * @date: 2020/5/12
 * @version: V1.0
 */
@RestController
@RequestMapping("/hello")
@Slf4j
public class HelloController {


  @GetMapping("/str")
  public String helloStr() {
    log.info(Thread.currentThread().getName()+"::aa");

    return "Hello World";
  }

  @GetMapping("/json")
  public Map<Object, Object> json() {
    return MapUtil.builder().put("success", true).put("message", "Hello World").build();
  }
}
