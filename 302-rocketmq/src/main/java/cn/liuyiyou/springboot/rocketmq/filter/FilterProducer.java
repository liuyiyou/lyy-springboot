package cn.liuyiyou.springboot.rocketmq.filter;

import cn.liuyiyou.springboot.rocketmq.RocketMQConfig;
import java.io.UnsupportedEncodingException;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;
import org.apache.rocketmq.remoting.exception.RemotingException;

/**
 * @author: liuyiyou.cn
 * @date: 2019/12/19
 * @version: V1.0
 */
public class FilterProducer {

  public static void main(String[] args)
      throws UnsupportedEncodingException, MQClientException, RemotingException,
      MQBrokerException, InterruptedException {

    DefaultMQProducer producer = new DefaultMQProducer();
    producer.setProducerGroup("filter");
    producer.setNamesrvAddr(RocketMQConfig.NAME_ADDR);
    producer.start();
    for (int i = 0; i < 10; i++) {
      Message message = new Message("topic-filter", "TagA",
          ("hello file - " + i).getBytes(RemotingHelper.DEFAULT_CHARSET));
      message.putUserProperty("a", String.valueOf(i));
      SendResult sendResult = producer.send(message);
      System.out.printf("%s%n", sendResult);
    }
    producer.shutdown();
  }
}
