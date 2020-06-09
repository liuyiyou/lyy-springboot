package cn.liuyiyou.springboot.log;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.Banner.Mode;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@Slf4j
public class LogApplication {

  public static void main(String[] args) {
    SpringApplication app = new SpringApplication(LogApplication.class);
    app.setBannerMode(Mode.OFF);
    app.run(args);
  }

  @GetMapping("/")
  public String home() {

    //logging.level.cn.liuyiyou.springboot.log=debug  则输出，负责只输出error。和root一样
    log.info("info");
    log.debug("debug");
    log.error("error");
    return "102-SpringBoot 日志";
  }

}
