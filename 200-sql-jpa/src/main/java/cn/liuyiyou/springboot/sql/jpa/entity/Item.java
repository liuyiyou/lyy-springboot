package cn.liuyiyou.springboot.sql.jpa.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Data;

/**
 * @author: liuyiyou.cn
 * @date: 2020/11/10
 * @version: V1.0
 */
@Entity
@Data
public class Item implements Serializable {

    @Id
    private Integer itemId;
    private String itemName;
    private String itemDescription;
    private Integer itemPrice;
}
