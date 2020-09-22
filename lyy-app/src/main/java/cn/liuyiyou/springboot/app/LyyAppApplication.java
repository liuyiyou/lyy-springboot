package cn.liuyiyou.springboot.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class LyyAppApplication {

    @Autowired
    private RedisTemplate<String, Object> customerRedisTemplate;

    public static void main(String[] args) {
        SpringApplication.run(LyyAppApplication.class, args);


    }

    @GetMapping("/")
    public Object home() {
        customerRedisTemplate.opsForValue().set("k", "v");
        return customerRedisTemplate.opsForValue().get("k");
    }


}
