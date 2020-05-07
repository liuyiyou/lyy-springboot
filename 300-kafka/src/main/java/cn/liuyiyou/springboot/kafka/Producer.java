package cn.liuyiyou.springboot.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

/**
 * @author: liuyiyou.cn
 * @date: 2020/5/7
 * @version: V1.0
 */
@Component
public class Producer {

  @Autowired
  private  KafkaTemplate kafkaTemplate;

  public void sendMsg(String msg){
    kafkaTemplate.send("myTopic",msg);
  }
}
