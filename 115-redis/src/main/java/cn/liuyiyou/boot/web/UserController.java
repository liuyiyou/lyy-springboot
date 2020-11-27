package cn.liuyiyou.boot.web;

import cn.liuyiyou.boot.entity.User;
import cn.liuyiyou.boot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: liuyiyou.cn
 * @date: 2020/11/26
 * @version: V1.0
 */
@RestController
@RequestMapping("/users")
public class UserController {


    @Autowired
    private UserService userService;

    @GetMapping("/add")
    public Boolean add(String name) {
        return userService.add(name);
    }

    @GetMapping("/{id}")
    public User get(@PathVariable Integer id) {
        return userService.findByIdCache(id);
    }

    @GetMapping("/safe/{id}")
    public User getSafe(@PathVariable Integer id) {
        return userService.findByIdCacheSafe(id);
    }

}
