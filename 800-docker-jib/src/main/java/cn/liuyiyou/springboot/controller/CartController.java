package cn.liuyiyou.springboot.controller;

import cn.liuyiyou.springboot.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: liuyiyou.cn
 * @date: 2020/7/24
 * @version: V1.0
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/cart")
public class CartController {

  private final CartService cartService;


  @GetMapping("/{id}")
  public Object getById(@PathVariable Integer id) {
    return cartService.findById(id);
  }


}
