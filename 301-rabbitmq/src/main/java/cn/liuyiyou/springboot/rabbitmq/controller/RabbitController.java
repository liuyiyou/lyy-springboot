package cn.liuyiyou.springboot.rabbitmq.controller;

import cn.hutool.core.thread.ThreadUtil;
import cn.liuyiyou.springboot.rabbitmq.send.SimpleSender;
import java.util.stream.IntStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: liuyiyou.cn
 * @date: 2020/6/9
 * @version: V1.0
 */
@RestController
@RequestMapping("/rabbit")
public class RabbitController {

  @Autowired
  private SimpleSender simpleSender;

  @GetMapping("/send")
  public String send(String message) {
    simpleSender.send(message);
    return "success";
  }

  @GetMapping("/simple")
  public String simple() {
    String message = "hello";
    IntStream.range(1, 10).forEach(i -> {
      simpleSender.send(message + "\t" + i);
      ThreadUtil.sleep(1000);
    });
    return "success";
  }

}
