package cn.liuyiyou.springboot.sql.jpa.service;

import cn.liuyiyou.springboot.sql.jpa.entity.Activity;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author: liuyiyou.cn
 * @date: 2021/3/24
 * @version: V1.0
 */
@SpringBootTest
@Slf4j
class ActivityServiceTest {

    @Autowired
    private ActivityService activityService;

    @Test
    void getEndOfDay() {
    }

    @Test
    void getInProgressActivities() {
        final List<Activity> inProgressActivities = activityService.getInProgressActivities("0174965149d8001b8a74827074964c1d");
        log.info("活动数量：{}", inProgressActivities.size());
    }
}