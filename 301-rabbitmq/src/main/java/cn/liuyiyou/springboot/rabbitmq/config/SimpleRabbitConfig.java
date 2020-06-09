package cn.liuyiyou.springboot.rabbitmq.config;

import cn.liuyiyou.springboot.rabbitmq.receiv.SimpleReceiver;
import cn.liuyiyou.springboot.rabbitmq.send.SimpleSender;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 创建一个名为simple.hello的队列、一个生产者和一个消费者；
 *
 * @author: liuyiyou.cn
 * @date: 2020/6/9
 * @version: V1.0
 */
@Configuration
public class SimpleRabbitConfig {

  @Bean
  public Queue hello() {
    return new Queue("simple.hello");
  }

  @Bean
  public SimpleSender simpleSender() {
    return new SimpleSender();
  }


  @Bean
  public SimpleReceiver simpleReceiver() {
    return new SimpleReceiver();
  }

}
