package cn.liuyiyou.springboot.sql.jpa.service;

import cn.liuyiyou.springboot.sql.jpa.entity.UserAddress;
import cn.liuyiyou.springboot.sql.jpa.repository.UserAddressRepository;
import java.util.List;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: liuyiyou.cn
 * @date: 2020/4/27
 * @version: V1.0
 */
@Service
@Slf4j
public class UserAddressService {

  @Autowired
  private UserAddressRepository userAddressRepository;

  public List<UserAddress> getAll() {
    return userAddressRepository.findAll();
  }

  public UserAddress save(UserAddress userAddress) {
    return userAddressRepository.save(userAddress);
  }

  public Optional<UserAddress> findUserAddreById(Integer id) {
    Optional<UserAddress> userOptional = userAddressRepository.findById(id);
    return userOptional;
  }

}
