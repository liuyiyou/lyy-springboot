package cn.liuyiyou.springboot.service;

import cn.liuyiyou.springboot.repository.GenericRepository;
import java.io.Serializable;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;


/***
 *
 * @author: liuyiyou.cn
 * @date: 2020/7/19
 * @Copyright 2020 liuyiyou.cn Inc. All rights reserved
 */
@Transactional(rollbackFor = Exception.class)
public abstract class GenericService<T, ID extends Serializable> {

  @Autowired
  private GenericRepository<T, ID> genericRepository;

  public T add(T t) {
    return genericRepository.save(t);
  }

  public T modify(T t) {
    return genericRepository.save(t);
  }

  public void deleteById(ID id) {
    Optional<T> tOptional = genericRepository.findById(id);
    if (tOptional.isPresent()) {
      genericRepository.deleteById(id);
    }
  }

  public T findById(ID id) {
    Optional<T> tOptional = genericRepository.findById(id);
    return tOptional.orElse(null);

  }

  public Page<T> page(Example<T> example,
      Pageable pageable) {
    //解决page=0开始的问题
    return genericRepository.findAll(example, pageable.previousOrFirst());
  }

  public Page<T> page(Pageable pageable) {
    //解决page=0开始的问题
    return genericRepository.findAll(pageable.previousOrFirst());
  }


}
