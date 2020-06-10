package cn.liuyiyou.springboot.sql.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import lombok.Data;
import lombok.ToString;

/**
 * @author: liuyiyou.cn
 * @date: 2020/4/27
 * @version: V1.0
 */
@Data
@Entity
@ToString
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  @Column
  private String name;
  @Column
  private String email;

  @OneToOne
  @JoinColumn(name = "userId")
  private UserAddress userAddress;

//  @OneToMany
//  @JoinColumn(name = "id")
//  private UserAddress userAddressList;
}
