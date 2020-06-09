package cn.liuyiyou.springboot.rabbitmq.send;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author: liuyiyou.cn
 * @date: 2020/6/9
 * @version: V1.0
 */
@Slf4j
public class SimpleSender {

  @Autowired
  private RabbitTemplate rabbitTemplate;

  private static final String queueName = "simple.hello";

  public void send(String message) {
    rabbitTemplate.convertAndSend(queueName, message);
    log.info("[x] Send '{}'", message);
  }

}
