package cn.liuyiyou.springboot.properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class PropertyApplication {

  @Autowired
  private ErpConfiguration erpConfiguration;

  @Value("${user.name}")
  private String name;
  @Value("${user.age}")
  private Integer age;

  public static void main(String[] args) {
    SpringApplication.run(PropertyApplication.class, args);
  }

  @GetMapping("/")
  public String home() {
    return name + "\t" + age + "\t" + erpConfiguration.toString();
  }
}
