package cn.liuyiyou.springboot.sql.jpa.web;

import cn.liuyiyou.springboot.sql.jpa.entity.User;
import cn.liuyiyou.springboot.sql.jpa.repository.UserRepository;
import java.util.List;
import java.util.Optional;
import javax.persistence.criteria.Predicate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: liuyiyou.cn
 * @date: 2020/4/27
 * @version: V1.0
 */
@RestController
@Slf4j
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/{id}")
    public Optional<User> get(@PathVariable("id") Integer id) {
        return userRepository.findById(id);
    }

    @GetMapping("/save")
    public User save(Integer id, String name) {
        User user = new User();
        user.setId(id);
        user.setName(name);
        return userRepository.save(user);
    }

    @GetMapping("/list")
    public List<User> list(User user, @PageableDefault Pageable pageable) {
        log.info("获取用户列表....");
        Specification<User> specification = getUserSpecification(user);
        return userRepository.pageList(specification, pageable.previousOrFirst());
    }

    @GetMapping("/listCount")
    public Long listCount(User user, @PageableDefault Pageable pageable) {
        log.info("获取用户数量...条件有limit.");
        Specification<User> specification = getUserSpecification(user);
        return userRepository.pageCount(specification, pageable);
    }

    private Specification<User> getUserSpecification(final User user) {
        return (Specification<User>) (root, query, criteriaBuilder) -> {
            Predicate predicate = criteriaBuilder.conjunction();
            if (user.getName() != null) {
                final Predicate name = criteriaBuilder.like(root.get("name"),
                    "%" + user.getName() + "%");
                predicate.getExpressions().add(name);
            }
            return predicate;
        };
    }

}
