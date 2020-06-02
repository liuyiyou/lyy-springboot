package cn.liuyiyou.springboot.properties;

import lombok.Data;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author: liuyiyou.cn
 * @date: 2020/6/2
 * @version: V1.0
 */
@ConfigurationProperties(prefix = "erp.liuyiyou")
@Data
@Configuration
@Slf4j
@ToString
public class ErpConfiguration {


  private String appKey;

  private String domain;

  private String apiVersion;

  private String apiUrl;

  private String apiSecret;

}
