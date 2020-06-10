package cn.liuyiyou.springboot.sql.jpa.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import lombok.ToString;

/**
 * @author: liuyiyou.cn
 * @date: 2020/6/9
 * @version: V1.0
 */
@Data
@Entity
@Table(name = "user_address")
@ToString
public class UserAddress {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private Integer userId;
  private String prov;
  private String city;
  private String county;

}
