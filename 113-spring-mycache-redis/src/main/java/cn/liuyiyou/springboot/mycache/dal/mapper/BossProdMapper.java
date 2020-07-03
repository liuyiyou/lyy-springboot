package cn.liuyiyou.springboot.mycache.dal.mapper;

import cn.hutool.db.Page;
import cn.liuyiyou.springboot.mycache.annotation.DelCache;
import cn.liuyiyou.springboot.mycache.annotation.GetCache;
import cn.liuyiyou.springboot.mycache.annotation.PostCache;
import cn.liuyiyou.springboot.mycache.annotation.PutCache;
import cn.liuyiyou.springboot.mycache.dal.entity.BossProd;

/**
 * @author: liuyiyou.cn
 * @date: 2020/7/3
 * @version: V1.0
 */
public interface BossProdMapper {


  /**
   * 新增对象
   * <pre>
   *   1-参数说明：必须有两个参数，第一个是主键ID，第二个是实体
   *   2-缓存说明：新增数据库->增加缓存
   *   3-返回值说明：必须是BossProd?
   * </pre>
   */
  @PostCache
  BossProd add(String id, BossProd entity);


  /**
   * 修改对象
   * <pre>
   *   1-参数说明：必须有两个参数，第一个是主键ID，第二个是实体
   *   2-缓存说明：必须先删除缓存->修改数据库->增加缓存
   *   3-返回值说明：必须是BossProd?
   * </pre>
   */
  @PutCache
  BossProd modify(String id, BossProd entity);

  /**
   * 查询单个对象
   * <pre>
   *   1-参数说明：必须有1个参数，第一个是主键ID
   *   2-缓存说明：有缓存走缓存，没缓存  加入缓存
   *   3-返回值说明：必须是BossProd
   * </pre>
   */
  @GetCache
  BossProd findById(String id);

  /**
   * 删除单个对象
   * <pre>
   *   1-参数说明：必须有1个参数，第一个是主键ID
   *   2-缓存说明：删除缓存
   *   3-返回值说明：必须是void
   *
   *   q: 是逻辑删除还是物理删除，如果是逻辑删除，则怎样保证一些唯一性索引之类的
   * </pre>
   */
  @DelCache
  void delete(String id);

  /**
   * 分页查询
   * <pre>
   *   1-参数说明：?
   *   2-缓存说明：不用缓存
   *   3-返回值说明：?
   *
   *   q: 是逻辑删除还是物理删除，如果是逻辑删除，则怎样保证一些唯一性索引之类的
   * </pre>
   */
  void findByPage();



}
