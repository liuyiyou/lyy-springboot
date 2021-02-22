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

    @KafkaListener(topics = "default-topic",groupId = "lyy-kafka")
    public void processMessage1_2(ConsumerRecord<String, String> consumerRecord) {
        log.info("等同于上面的");
        log.info("processMessage1_2：topics = \"default-topic\"");
    }

    @KafkaListener(topics = "default-topic")
    public void processMessage2(ConsumerRecord<String, String> consumerRecord) {
        log.info("processMessage2：topics = \"default-topic\"");
    }

    @KafkaListener(topics = "default-topic", groupId = "myGroup")
    public void preocessConsumerRecord(Object object) {
        log.info("topics = \"default-topic\", groupId = \"myGroup\"");
    }

    @KafkaListener(topics = "default-topic", groupId = "myGroup")
    public void processMessage3(ConsumerRecord<String, String> consumerRecord) {
        log.info("processMessage3：topics = \"default-topic\", groupId = \"myGroup\"");
    }

    @KafkaListener(topics = "default-topic", groupId = "myGroup2")
    public void processMessage4(ConsumerRecord<String, String> consumerRecord) {
        log.info("processMessage4：topics = \"default-topic\", groupId = \"myGroup2\"");
    }





}
