package cn.liuyiyou.boot.kafka.consumer;

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
public class Consumer {

    @KafkaListener(topics = "default-topic",groupId = "lyy-kafka")
    public void processMessage(String msg) {
        log.info("Consumer");
        log.info(msg);
    }


}
