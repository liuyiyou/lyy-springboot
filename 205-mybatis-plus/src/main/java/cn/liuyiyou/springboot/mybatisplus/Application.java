package cn.liuyiyou.springboot.mybatisplus;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@MapperScan("cn.liuyiyou.springboot.mybatisplus.**.mapper")
@RestController
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }


    @GetMapping("/")
    public String home() {
        return "205-mybatis-plus";
    }
}
