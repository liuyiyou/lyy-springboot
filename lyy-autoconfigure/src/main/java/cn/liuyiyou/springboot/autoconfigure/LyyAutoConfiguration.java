package cn.liuyiyou.springboot.autoconfigure;

import javax.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author: liuyiyou.cn
 * @date: 2019/11/28
 * @version: V1.0
 */
@Configuration
@EnableConfigurationProperties(LyyProperties.class)
@Slf4j
public class LyyAutoConfiguration {

  @Autowired
  private LyyProperties lyyProperties;

  @PostConstruct
  public void sys() {
    log.info(lyyProperties.getName(), lyyProperties.getAge());
    log.info("永远18");
  }
}
