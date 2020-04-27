package cn.liuyiyou.springboot.log;

import org.springframework.boot.Banner.Mode;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Application {

  public static void main(String[] args) {
    SpringApplication app = new SpringApplication(Application.class);
    app.setBannerMode(Mode.OFF);
    app.run(args);
  }

  @GetMapping("/")
  public String home() {
    return "102-SpringBoot 日志";
  }

}
