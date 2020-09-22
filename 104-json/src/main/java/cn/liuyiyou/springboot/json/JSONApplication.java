package cn.liuyiyou.springboot.json;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@Slf4j
public class JSONApplication {

    public static void main(String[] args) {
        SpringApplication.run(JSONApplication.class, args);
    }

    @GetMapping("/get")
    public Goods getGoods() {
        Goods goods = new Goods();
        goods.setId(1);
        goods.setName("手机");
        goods.setLocalDateTime(LocalDateTime.now());
        goods.setDate(new Date());
        goods.setInstant(Instant.now());

        goods.setLocalDateTimeFormat(LocalDateTime.now());
        goods.setDateFormat(new Date());
        goods.setInstantFormat(Instant.now());
        return goods;
    }

    @PostMapping("/add")
    public Goods getGoods(@RequestBody Goods goods) {
        log.info(goods.toString());
        return goods;
    }

}
