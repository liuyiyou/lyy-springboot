package cn.liuyiyou.springboot.exception.web;

import cn.liuyiyou.springboot.exception.Prod;
import cn.liuyiyou.springboot.exception.ProdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: liuyiyou.cn
 * @date: 2020/5/12
 * @version: V1.0
 */
@RestController
@RequestMapping("/prod")
public class ProdController {


  @Autowired
  private ProdService prodService;

  @GetMapping("/{id}")
  public Prod findById(@PathVariable Integer id) {
    return prodService.findById(id);
  }

  @GetMapping("/npeExcepton")
  public void npeExcepton() {
     new Prod().getName().length();
  }


  @GetMapping("/exception1")
  public void exception1() {
    int i = 1 / 0;
  }

  @GetMapping("/exception2")
  public void exception2() {
    throw new RuntimeException("run time");
  }
}
