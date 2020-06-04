package cn.liuyiyou.springboot.quartz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@RestController
@EnableScheduling
public class Application {


  public static ConfigurableApplicationContext applicationContext;


  public static void main(String[] args) {
    applicationContext = SpringApplication.run(Application.class, args);
  }

  @GetMapping("/")
  public String home() {
    return "";
  }
}
