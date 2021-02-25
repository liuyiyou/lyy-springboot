package cn.liuyiyou.springboot.kafka.consumer;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
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

    @KafkaListener(topics = "default-topic")
    public void processMessage(ConsumerRecord<String, String> consumerRecord) {
        log.info("processMessage：topics = \"default-topic\"");
    }
}
