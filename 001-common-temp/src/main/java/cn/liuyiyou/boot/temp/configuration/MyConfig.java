package cn.liuyiyou.boot.temp.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: liuyiyou.cn
 * @date: 2021/3/11
 * @version: V1.0
 */
@Configuration(proxyBeanMethods = true)
public class MyConfig {

    @Bean
    public MyBean myBean() {
        final MyBean myBean = new MyBean();
        return myBean;
    }

    @Bean
    public YourBean yourBean() {
        return new YourBean(myBean());
    }
}
