package cn.liuyiyou.springboot.sql.jpa.service;

import cn.liuyiyou.springboot.sql.jpa.entity.Activity;
import cn.liuyiyou.springboot.sql.jpa.repository.ActivityRepository;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

/**
 * @author: liuyiyou.cn
 * @date: 2021/3/24
 * @version: V1.0
 */
@Slf4j
@Service
public class ActivityService {

    @Autowired
    private ActivityRepository activityRepository;

    public static Instant getEndOfDay() {
        final LocalDateTime endOfDay = LocalDateTime.of(LocalDate.now(), LocalTime.MAX);
        return endOfDay.atZone(ZoneId.of("Asia/Shanghai")).toInstant();
    }

    public List<Activity> getInProgressActivities(String tenantId) {
        final Instant endOfDay = getEndOfDay();
        log.info(LocalDateTime.ofInstant(endOfDay,ZoneId.systemDefault()).format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        List<Activity> getInProgressActivities  = activityRepository
            .findByEndTimeBeforeAndStatusIsTrueAndAuditStatusAndTenantId(
                endOfDay,4,tenantId);
        if(!CollectionUtils.isEmpty(getInProgressActivities)){
            getInProgressActivities = getInProgressActivities.stream()
                .filter(activity -> activity!= null
                    && (activity.getEndTime() == null || activity.getEndTime().compareTo(Instant.now()) > 0 )
                ).sorted(Comparator.comparing(Activity::getSortOrder).reversed()
                    .thenComparing(Activity::getLastModifiedDate, Comparator.reverseOrder()))
                .collect(Collectors.toList());
        }
        return getInProgressActivities;
    }


}
