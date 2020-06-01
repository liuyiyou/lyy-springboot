package cn.liuyiyou.springboot.mybatis.mapper;

import cn.liuyiyou.springboot.mybatis.entity.City;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public interface CityMapper {

  int insert(City record);

  List<City> selectAll();
}