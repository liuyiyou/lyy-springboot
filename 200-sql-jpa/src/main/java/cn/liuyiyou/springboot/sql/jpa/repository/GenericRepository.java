package cn.liuyiyou.springboot.sql.jpa.repository;

import java.io.Serializable;
import java.util.List;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * @author: liuyiyou.cn
 * @date: 2020/11/4
 * @version: V1.0
 */
@NoRepositoryBean
public interface GenericRepository<T, ID extends Serializable> extends JpaRepository<T, ID>, JpaSpecificationExecutor<T> {

    List<T> pageList(Specification<T> spec, Pageable pageable);

    List<T> pageList(Example<T> example, Pageable pageable);

    Long pageCount(Specification<T> spec, Pageable pageable);

    Long pageCount(Example<T> example, Pageable pageable);
}