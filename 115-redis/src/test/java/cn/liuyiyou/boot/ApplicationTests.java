package cn.liuyiyou.boot;

import cn.liuyiyou.boot.entity.User;
import cn.liuyiyou.boot.repository.UserRepository;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

@SpringBootTest
class ApplicationTests {

    @Autowired
    private UserRepository userRepository;
    @Test
    void contextLoads() {
        for(int i = 1; i<=10;i++){
            User user = new User();
            user.setId(i);
            user.setName("lyy"+i);
            userRepository.save(user);
        }
    }



    @Test
    void getById(){
        final Optional<User> byId = userRepository.findById(1);
        Optional.ofNullable(byId).ifPresent(byId2->{
            System.out.println(byId2.get().getName());
        });
    }

    @Test
    void list(){
        final Page<User> all = userRepository.findAll(PageRequest.of(0, 5));
        System.out.println(all.getTotalPages());
    }

}
