package cn.liuyiyou.springboot.sql.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: liuyiyou.cn
 * @date: 2020/11/10
 * @version: V1.0
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    @Column(unique = true)
    private String isbn;

    public Book(String title, String isbn) {
        this.title = title;
        this.isbn = isbn;
    }
}
