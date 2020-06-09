package cn.liuyiyou.springboot.hello;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class HelloApplication {

  public static void main(String[] args) {
//    SpringApplication.run(Application.class, args);
    //        SpringApplication app = new SpringApplication(HelloApplication.class);
//        //关闭横幅
//        app.setBannerMode(Banner.Mode.OFF);
//        app.run(args);
    new SpringApplicationBuilder()
        .sources(HelloApplication.class)
//        .bannerMode(Banner.Mode.OFF)
        .run(args);
  }


  @GetMapping("/")
  public String home() {
    return "success";
  }
}
