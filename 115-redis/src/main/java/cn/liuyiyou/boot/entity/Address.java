package cn.liuyiyou.boot.entity;

import lombok.Data;
import org.springframework.data.redis.core.RedisHash;

/**
 * @author: liuyiyou.cn
 * @date: 2021/3/20
 * @version: V1.0
 */
@Data
@RedisHash("address")
public class Address {

    private Integer id;
    private String prov;
    private String city;
    private String county;
}
