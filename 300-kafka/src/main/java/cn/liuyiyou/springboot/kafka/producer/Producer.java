package cn.liuyiyou.springboot.kafka.producer;

import java.util.concurrent.CompletableFuture;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

/**
 * @author: liuyiyou.cn
 * @date: 2020/5/7
 * @version: V1.0
 */
@Component
@Slf4j
public class Producer {

    @Autowired
    private KafkaTemplate kafkaTemplate;


    /**
     * https://blog.csdn.net/hadues/article/details/88250249 事务消息
     */
    public void sendMsg(String topic, String message, boolean userTransaction) {
        if (userTransaction) {
            kafkaTemplate.executeInTransaction(t -> {
                t.send(topic, message);
                return true;
            });
        }
    }

    public ListenableFuture<String> sendMsg(String msg) {
        ListenableFuture<String> send = kafkaTemplate.send("default-topic", msg);
        send.addCallback(new ListenableFutureCallback<String>() {
            @Override
            public void onFailure(Throwable throwable) {
                log.error("发送失败", throwable);
            }

            @Override
            public void onSuccess(String o) {
                log.info("发送成功");
            }
        });
        return send;
    }


    public void sendMsg(String topic, String message) {
        kafkaTemplate.send(new ProducerRecord(topic, "myKey", message));
    }
}
