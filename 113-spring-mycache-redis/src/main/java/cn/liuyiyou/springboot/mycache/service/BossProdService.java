package cn.liuyiyou.springboot.mycache.service;

import cn.hutool.core.lang.Assert;
import cn.liuyiyou.springboot.mycache.annotation.CachePrefix;
import cn.liuyiyou.springboot.mycache.annotation.DelCache;
import cn.liuyiyou.springboot.mycache.annotation.GetCache;
import cn.liuyiyou.springboot.mycache.annotation.PageCache;
import cn.liuyiyou.springboot.mycache.annotation.PostCache;
import cn.liuyiyou.springboot.mycache.annotation.PutCache;
import cn.liuyiyou.springboot.mycache.dal.entity.BossProd;
import cn.liuyiyou.springboot.mycache.dal.repository.BossProdRepository;
import cn.liuyiyou.springboot.mycache.utils.PageUtil;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
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

  @PostCache(key = "bossProdId")
  public BossProd add(BossProd bossProd) {
    bossProd.setBossProdId(999101010008L);
    return bossProd;
  }

  @GetCache
  public BossProd findById(Long id) {
    Optional<BossProd> bossProdOptional = bossProdRepository.findById(id);
    return bossProdOptional.orElse(new BossProd());
  }

  @PutCache
  public BossProd modify(Long id, BossProd bossProd) {
    Assert.isTrue(id.equals(bossProd.getBossProdId()));
    return bossProdRepository.save(bossProd);
  }

  @DelCache
  public void delete(Long id) {
//    bossProdRepository.deleteById(id);
  }

  @PageCache
  public Object pageCache(Pageable pageable) {
    Page<BossProd> all = bossProdRepository.findAll(pageable);
    return PageUtil.toPage(all);
  }


}
