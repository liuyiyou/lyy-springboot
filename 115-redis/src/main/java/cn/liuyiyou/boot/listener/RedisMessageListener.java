package cn.liuyiyou.boot.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.stereotype.Component;

/**
 * @author: liuyiyou.cn
 * @date: 2021/3/31
 * @version: V1.0
 */
@Component
@Slf4j
public class RedisMessageListener implements MessageListener {

    @Override
    public void onMessage(final Message message, final byte[] pattern) {
        String topic = new String(message.getChannel());
        String content = new String(message.getBody());
        log.info(topic);
        log.info(content);
    }
}
