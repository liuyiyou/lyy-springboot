package cn.liuyiyou.springboot.sql.jpa.repository;

import cn.liuyiyou.springboot.sql.jpa.entity.Activity;
import java.time.Instant;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author: liuyiyou.cn
 * @date: 2021/3/24
 * @version: V1.0
 */
@SpringBootTest
class ActivityRepositoryTest {

    @Autowired
    private ActivityRepository activityRepository;

    @DisplayName("自动生成表结构，看Instant默认映射类型")
    @Test
    void add() {
        Activity activity = new Activity();
        activityRepository.save(activity);
    }
}