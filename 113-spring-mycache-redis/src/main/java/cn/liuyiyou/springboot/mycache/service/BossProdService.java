package cn.liuyiyou.springboot.mycache.service;

import cn.liuyiyou.springboot.mycache.entity.BossProd;
import cn.liuyiyou.springboot.mycache.repository.BossProdRepository;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @author: liuyiyou.cn
 * @date: 2020/7/2
 * @version: V1.0
 */
@Service
@CacheConfig(cacheNames = "prods")
public class BossProdService {

  @Autowired
  private  BossProdRepository bossProdRepository;

  @Cacheable(value = "prod", key = "#id")
  public BossProd findById(Long id) {
    Optional<BossProd> bossProdOptional = bossProdRepository.findById(id);
    return bossProdOptional.orElse(new BossProd());
  }

}
