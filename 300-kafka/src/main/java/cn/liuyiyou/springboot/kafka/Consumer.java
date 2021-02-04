package cn.liuyiyou.springboot.kafka;

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

    @KafkaListener(topics = "default-topic", groupId = "myGroup")
    public void processMessage(String msg) {
        log.info("topics = \"default-topic\", groupId = \"myGroup\"");
        log.info(msg);
    }

    @KafkaListener(topics = "default-topic", groupId = "myGroup")
    public void preocessConsumerRecord(ConsumerRecord<String, String> consumerRecord) {
        log.info("ConsumerRecord"+"topics = \"default-topic\", groupId = \"myGroup\"");
        log.info(consumerRecord.toString());
    }

    //这个同上。 返回 ConsumerRecord(topic = default-topic, partition = 2, leaderEpoch = 0, offset = 11, CreateTime = 1591779198621, serialized key size = -1, serialized value size = 5, headers = RecordHeaders(headers = [], isReadOnly = false), key = null, value = MyMsg)
    @KafkaListener(topics = "default-topic", groupId = "myGroup")
    public void preocessConsumerRecord(Object object) {
        log.info("object");
        log.info(object.toString());
    }

}
