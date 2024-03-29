package cn.liuyiyou.boot.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

/**
 * @author: liuyiyou.cn
 * @date: 2020/11/26
 * @version: V1.0
 */
@Data
@RedisHash("user")
public class User {

    @Id
    private Integer id;
    private String name;
//    private Address address;
}
