package cn.liuyiyou.springboot.json;

import java.time.LocalDateTime;
import java.util.Date;
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

  @GetMapping("/")
  public Goods getGoods() {
    Goods goods = new Goods();
    goods.setId(1);
    goods.setName("手机");
    goods.setCreateTime(LocalDateTime.now());
    goods.setUpdateTime(new Date());
    return goods;
  }

}
