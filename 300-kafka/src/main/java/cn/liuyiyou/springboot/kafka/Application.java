package cn.liuyiyou.springboot.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Application {

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }


  @Autowired
  private Producer producer;

  @GetMapping({"/"})
  public String home(){
    producer.sendMsg("MyMsg");
    return "300-kafka";
  }

}
