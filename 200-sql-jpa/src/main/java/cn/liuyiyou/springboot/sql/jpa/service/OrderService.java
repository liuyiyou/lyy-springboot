package cn.liuyiyou.springboot.sql.jpa.service;

import cn.liuyiyou.springboot.sql.jpa.repository.OrderRepository;
import java.math.BigDecimal;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author: liuyiyou.cn
 * @date: 2020/12/20
 * @version: V1.0
 */
@Service
@Slf4j
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(final OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Integer orderCount() {
        final Instant minus = Instant.now().minus(11, ChronoUnit.DAYS);
        Map<Integer, BigDecimal> count = orderRepository.countOrder(minus);
        log.info("使用@Query查询:{},{}", count.get("orderCount"),count.get("totalAmount"));
        return orderRepository.countByCreatedTimeAfterAndIsPaidIsTrueAndIsTradingClosedIsFalse(minus);
    }
}
