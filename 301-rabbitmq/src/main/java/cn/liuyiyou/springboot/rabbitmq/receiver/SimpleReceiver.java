package cn.liuyiyou.springboot.rabbitmq.receiver;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

/**
 * @author: liuyiyou.cn
 * @date: 2020/6/9
 * @version: V1.0
 */
@Slf4j
@RabbitListener(queues = "simple")
public class SimpleReceiver {

  @RabbitHandler
  public void receive(String message) {
    log.info("[X] received '{}'", message);
  }

}
