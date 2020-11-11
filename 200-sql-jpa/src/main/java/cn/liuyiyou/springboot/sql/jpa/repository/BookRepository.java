package cn.liuyiyou.springboot.sql.jpa.repository;

import cn.liuyiyou.springboot.sql.jpa.entity.Book;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 * @author: liuyiyou.cn
 * @date: 2020/11/10
 * @version: V1.0
 */
public interface BookRepository extends CrudRepository<Book, Long> {

    Book findByIsbn(String isbn);

    List<Book> findByTitleContaining(String title);
}
