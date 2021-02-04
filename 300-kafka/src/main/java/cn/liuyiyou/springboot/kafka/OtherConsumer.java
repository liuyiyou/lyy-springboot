package cn.liuyiyou.springboot.kafka;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

/**
 * @author: liuyiyou.cn
 * @date: 2020/5/7
 * @version: V1.0
 */
@Component
@Slf4j
public class OtherConsumer {

    @Autowired
    private KafkaTemplate kafkaTemplate;


    @KafkaListener(topics = "default-topic")
    public void processMessage(String msg) {
        log.info("OtherConsumer");
        log.info(msg);
    }

}
