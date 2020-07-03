package cn.liuyiyou.springboot.mycache.service;

import cn.liuyiyou.springboot.mycache.annotation.CachePrefix;
import cn.liuyiyou.springboot.mycache.annotation.GetCache;
import cn.liuyiyou.springboot.mycache.annotation.PageCache;
import cn.liuyiyou.springboot.mycache.annotation.PutCache;
import cn.liuyiyou.springboot.mycache.entity.BossProd;
import cn.liuyiyou.springboot.mycache.repository.BossProdRepository;
import cn.liuyiyou.springboot.mycache.utils.PageUtil;
import java.time.LocalDateTime;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * @author: liuyiyou.cn
 * @date: 2020/7/2
 * @version: V1.0
 */
@Service
@CachePrefix(classPrefix = "BossProd")
public class BossProdService {

  @Autowired
  private BossProdRepository bossProdRepository;

//  @Cacheable(value = "prod")
////  @GetCache
//  public BossProd findById2(Long id) {
//    Optional<BossProd> bossProdOptional = bossProdRepository.findById(id);
//    return bossProdOptional.orElse(new BossProd());
//  }

  @GetCache
  public BossProd findById(Long id) {
    Optional<BossProd> bossProdOptional = bossProdRepository.findById(id);
    return bossProdOptional.orElse(new BossProd());
  }

  @PageCache
  public Object pageCache(Pageable pageable) {
    bossProdRepository.deleteAll();
    Page<BossProd> all = bossProdRepository.findAll(pageable);
    return PageUtil.toPage(all);
  }

  public BossProd updateBySelective(BossProd bossProd){
    return bossProdRepository.save(bossProd);
  }

  @PutCache
  public BossProd updateById(Long id) {
    Optional<BossProd> bossProdOptional = bossProdRepository.findById(id);
    if (bossProdOptional.isPresent()) {
      BossProd bossProd = bossProdOptional.get();
      bossProd.setCreateTime(LocalDateTime.now());
      return bossProdRepository.save(bossProd);
    }else{
      return new BossProd();
    }

  }

  @Cacheable
  public Object page(Pageable pageable) {
    Page<BossProd> all = bossProdRepository.findAll(pageable);
    return PageUtil.toPage(all);
  }

  public BossProd save(BossProd bossProd){
    return  bossProdRepository.save(bossProd);
  }

}
