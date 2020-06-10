package cn.liuyiyou.springboot.kafka.partition;

import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.internals.DefaultPartitioner;

/**
 * @author: liuyiyou.cn
 * @date: 2020/6/10
 * @version: V1.0
 */
@Slf4j
public class MyPartitioner extends DefaultPartitioner {

  @Override
  public void configure(Map<String, ?> configs) {
    log.info("这是自定义分区器");
    super.configure(configs);
  }
}
