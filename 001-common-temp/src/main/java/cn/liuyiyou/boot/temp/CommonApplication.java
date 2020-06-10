package cn.liuyiyou.boot.temp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CommonApplication {


//  @Bean
//  public BeanLifecycle beanLifecycle() {
//    BeanLifecycle beanLifecycle = new BeanLifecycle();
//    beanLifecycle.setName("BeanLifecycle");
//    return beanLifecycle;
//  }

  public static void main(String[] args) {
    ConfigurableApplicationContext applicationContext = SpringApplication
        .run(CommonApplication.class, args);
    BeanLifecycle bean = applicationContext.getBean(BeanLifecycle.class);
    String name = bean.getName();
    System.out.println(name);
  }

}
