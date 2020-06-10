package cn.liuyiyou.springboot.kafka.interceptor;

import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.ProducerInterceptor;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

/**
 * @author: liuyiyou.cn
 * @date: 2020/6/10
 * @version: V1.0
 */
@Slf4j
public class MyProducerInterceptor implements ProducerInterceptor<String,String>{

  /**
   * KafkaProducer在将消息序列化和计算分区之前会调用生产者拦截器的onSend（）方法来对消息进行相应的定制化操作。一般来说最好不要修改消息 ProducerRecord 的 topic、key 和partition 等信息，如果要修改，则需确保对其有准确的判断，否则会与预想的效果出现偏差。比如修改key不仅会影响分区的计算，同样会影响broker端日志压缩（Log Compaction）的功能。
   * @param record
   * @return
   */
  @Override
  public ProducerRecord<String, String> onSend(ProducerRecord<String, String> record) {
    log.info("调用拦截器的onSend方法");
    return record;
  }

  /**
   * 会在消息被应答（Acknowledgement）之前或消息发送失败时调用生产者拦截器的onAcknowledgement（）方法，优先于用户设定的 Callback 之前执行。这个方法运行在Producer 的 I/O 线程中，所以这个方法中实现的代码逻辑越简单越好，否则会影响消息的发送速度。
   * @param metadata
   * @param exception
   */
  @Override
  public void onAcknowledgement(RecordMetadata metadata, Exception exception) {
    log.info("拦截器的应答(onAcknowledgement)方法");
  }

  /**
   * 方法主要用于在关闭拦截器时执行一些资源的清理工作。在这 3 个方法中抛出的异常都会被捕获并记录到日志中，但并不会再向上传递。
   */
  @Override
  public void close() {

  }

  @Override
  public void configure(Map<String, ?> configs) {

  }
}
