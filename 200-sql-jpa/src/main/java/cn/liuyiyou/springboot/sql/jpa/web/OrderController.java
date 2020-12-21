package cn.liuyiyou.springboot.sql.jpa.web;

import cn.liuyiyou.springboot.sql.jpa.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: liuyiyou.cn
 * @date: 2020/12/20
 * @version: V1.0
 */
@RestController
public class OrderController {

    private final OrderService orderService;

    public OrderController(final OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/orderCount")
    public Integer getOrderCount() {
        return orderService.orderCount();
    }
}
