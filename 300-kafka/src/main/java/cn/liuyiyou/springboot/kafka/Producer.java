package cn.liuyiyou.springboot.kafka;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import java.util.concurrent.CompletableFuture;

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

    public void sendMsg(String msg) {
        ListenableFuture<String> send = kafkaTemplate.send("myTopic", msg);
        send.addCallback(new ListenableFutureCallback<String>() {
            @Override
            public void onFailure(Throwable throwable) {
                log.error("发送失败", throwable);
            }

            @Override
            public void onSuccess(String o) {
                log.info("发送成功", o);
            }
        });
    }


    public void sendMsg(String topic, String message) {
        ListenableFuture send = kafkaTemplate.send(new ProducerRecord(topic, message));
        CompletableFuture completable = send.completable();
    }
}
