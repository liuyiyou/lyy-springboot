package cn.liuyiyou.springboot.service;

import cn.liuyiyou.springboot.entity.Cart;
import cn.liuyiyou.springboot.repository.CartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author: liuyiyou.cn
 * @date: 2020/7/24
 * @version: V1.0
 */
@Service
@RequiredArgsConstructor
public class CartService extends GenericService<Cart, Integer> {

  private final CartRepository cartRepository;
}
