package cn.liuyiyou.springboot.ecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: liuyiyou.cn
 * @date: 2020/6/9
 * @version: V1.0
 */
@RestController
@RequestMapping("/admin")
public class AdminController {

  @GetMapping("/demo")
  public String demo() {
    return "AdminController";
  }
}
