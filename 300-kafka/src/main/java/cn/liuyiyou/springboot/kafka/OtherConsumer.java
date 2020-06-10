package cn.liuyiyou.springboot.kafka;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @author: liuyiyou.cn
 * @date: 2020/5/7
 * @version: V1.0
 */
@Component
@Slf4j
public class OtherConsumer {

//  @KafkaListener(topics = "default-topic")
//  public void processMessage(String msg){
//    log.info("OtherConsumer");
//    log.info(msg);
//  }

}
