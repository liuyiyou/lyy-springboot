package cn.liuyiyou.springboot.sql.jpa.repository;

import cn.liuyiyou.springboot.sql.jpa.entity.Order;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.Map;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Spring Data JPA repository for the {@link Order} entity.
 *
 * @author next auto generator 2020-12-20
 */
public interface OrderRepository extends JpaRepository<Order, String>, JpaSpecificationExecutor<Order> {


    /**
     * 过去两小时的订单条数
     */
    Integer countByCreatedTimeAfterAndIsPaidIsTrueAndIsTradingClosedIsFalse(Instant time);


    @Query(nativeQuery = true, value="select  count(*) as orderCount, sum(pay_amount) as  totalAmount from `order`  where created_time >= :cratedTime")
    Map<Integer, BigDecimal> countOrder(@Param("cratedTime") Instant cratedTime);


}