package cn.liuyiyou.springboot.kafka;

import java.time.Duration;
import java.util.Collections;
import java.util.Properties;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;

public class MyKafkaConsumer {

    private static Properties initConfig() {
        String server = "192.168.0.215:9092,192.168.0.215:9093,192.168.0.215:9094";
        Properties props = new Properties();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, server);
        props.put(ConsumerConfig.CLIENT_ID_CONFIG, "myclient.id");
        props.put(ConsumerConfig.GROUP_ID_CONFIG, "group.demo");
        //禁止自动提交位移，避免多线程消费出现消息丢失
        props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, false);
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
//        props.put(ConsumerConfig.SESSION_TIMEOUT_MS_CONFIG,100);
        props.put(ConsumerConfig.HEARTBEAT_INTERVAL_MS_CONFIG, 30);
        //控制单次调用call方法能够返回的记录数量，帮助控制在轮询里需要处理的数据量。
        props.put(ConsumerConfig.MAX_POLL_RECORDS_CONFIG, 1);
        return props;
    }


    public static void main(String[] args) {
        String topic = "topic-name";
        Properties props = initConfig();
        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props);
        consumer.subscribe(Collections.singletonList(topic));
        try {
            while (true) {
                ConsumerRecords<String, String> records = consumer.poll(Duration.ofSeconds(10));
                System.out.println("取出数量" + records.count());
                for (ConsumerRecord<String, String> record : records) {
                    System.out.println("=========================================================================");
                    System.out.println("topic=" + record.topic() + "\tpartition=" + record.partition() + "\toffset=" + record.offset());
                    System.out.println("key=" + record.key() + "\tvalue" + record.value());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            consumer.close();
        }
    }
}
