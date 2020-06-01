package cn.liuyiyou.springboot.mybatis;

import cn.liuyiyou.springboot.mybatis.entity.City;
import cn.liuyiyou.springboot.mybatis.mapper.CityMapper;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ApplicationTests {


  @Autowired
  private CityMapper cityMapper;

  @Test
  void contextLoads() {

    final List<City> cities = cityMapper.selectAll();
  }

}
