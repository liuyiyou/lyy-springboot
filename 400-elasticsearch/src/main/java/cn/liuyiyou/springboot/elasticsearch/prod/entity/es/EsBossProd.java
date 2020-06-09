package cn.liuyiyou.springboot.elasticsearch.prod.entity.es;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.Mapping;
import org.springframework.data.elasticsearch.annotations.Setting;

import javax.persistence.Id;
import java.io.Serializable;

/**
 * <p>
 * BOSS 商品信息表，支持：
 * <p>
 * 1、对原子商品 prod 的继承扩展 。 这种情况下，只是将prod 里面的记录附加一下洋老板平台的必要信息 。
 * <p>
 * 2、对原子商品，商品SKU的组合打包。这种情况下，则是对不同原子商品(基础商品)组合，然后重新定义SKU。
 * </p>
 *
 * @author liuyiyou
 * @since 2020-05-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
//@Entity
//指定index索引名称为项目名   指定type类型名称为实体名
@Document(indexName = "bossprod_index", type = "bossProd")
//相当于ES中的mapping    注意对比文件中的json和原生json  最外层的key是没有的
//@Mapping(mappingPath = "bossProd-mapping.json")
//相当于ES中的settings   注意对比文件中的json和原生json  最外层的key是没有的
//@Setting(settingPath = "bossProd-setting.json")
public class EsBossProd implements Serializable {

    @Id
    private Long id;

    private String prodName;

    private Long prodId;


}
