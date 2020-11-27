package cn.liuyiyou.boot.service;

import cn.hutool.json.JSONUtil;
import cn.liuyiyou.boot.entity.User;
import java.time.Instant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * @author: liuyiyou.cn
 * @date: 2020/11/26
 * @version: V1.0
 */
@Service
@Slf4j
public class UserService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    public boolean add(String name) {
        int update = jdbcTemplate.update("insert  into  user(name) values (?)", name);
        return update > 0;
    }


    public User findByIdCacheSafe(Integer id) {
        log.info("开始时间:" + Instant.now().toString());
        String s = null;
        try {
            s = redisTemplate.opsForValue().get("User:" + id);
            if (StringUtils.isEmpty(s)) {
                log.info("从数据库获取");
                User user = findById(id);
                redisTemplate.opsForValue().set("User:" + id, JSONUtil.toJsonStr(user));
                return user;
            } else {
                log.info("从缓存获取");
                return JSONUtil.toBean(s, User.class);
            }
        } catch (Exception e) {
            log.info("redis错误，从数据库中获取");
            return findById(id);
        }
    }

    public User findByIdCache(Integer id) {
        log.info("开始时间:" + Instant.now().toString());
        String s = redisTemplate.opsForValue().get("User:" + id);
        log.info("结束时间:" + Instant.now().toString());
        if (StringUtils.isEmpty(s)) {
            log.info("从数据库获取");
            User user = findById(id);
            redisTemplate.opsForValue().set("User:" + id, JSONUtil.toJsonStr(user));
            return user;
        } else {
            log.info("从缓存获取");
            return JSONUtil.toBean(s, User.class);
        }
    }

    private User findById(Integer id) {
        return jdbcTemplate.queryForObject("select * from user where  id = ?", new Object[]{id}, (resultSet, rowNum) -> {
            User user = new User();
            user.setId(resultSet.getInt("id"));
            user.setName(resultSet.getString("name"));
            return user;
        });
    }
}
