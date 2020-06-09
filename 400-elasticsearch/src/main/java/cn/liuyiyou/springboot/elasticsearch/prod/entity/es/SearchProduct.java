//package cn.liuyiyou.springboot.elasticsearch.prod.entity.es;
//
//import java.io.Serializable;
////import javax.validation.constraints.NotNull;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//import lombok.experimental.Accessors;
//import org.springframework.data.elasticsearch.annotations.Document;
//import org.springframework.data.elasticsearch.annotations.Mapping;
//import org.springframework.data.elasticsearch.annotations.Setting;
//
//
///**
// * @author liuyiyou
// * @Date 2018.06.22
// */
//@Data
//@Accessors(chain = true)
//@Document(indexName = "prod_index", type = "search_product_type")
//@Mapping(mappingPath = "boss_prodmapping.json")
//@Setting(settingPath = "common_index_setting.json")
//@NoArgsConstructor
//@AllArgsConstructor
//public class SearchProduct implements Serializable {
//
////  @NotNull
//  private Long id;
//  private Long skuId;
//  private Long actId;
////  @NotNull
//  private Long prodId;
//  private Long lastUpdate;
////  @NotNull
//  private String prodName;
//  private String prodAttr;
//  private String brandName;
//  private String cataName;
//  private String firstCataName;
//  private String thirdCataName;
////  @NotNull
//  private String createDate;
////  @NotNull
//  private String pic;
//  private String countryId;
//  private String countryName;
//  private String brandNameEn;
////  @NotNull
//  private Float prodPrice;
////  @NotNull
//  private Float referPrice;
//  private Float commission;
//
//  private Integer prodTotal;
//  private Integer virtualStock;
//  private Integer brandId;
//  private Integer cataId;
//  private Integer thirdCataId;
//  private Integer firstCataId;
////  @NotNull
//  private Integer scope;
////  @NotNull
//  private Boolean isCombo;
//  private Integer newFlag;
//  private Integer hotFlag;
//  private String flagLabel;
//  private Integer saleChannel;
//  private Integer saledTotal;
//  private String promotionStartTime;
//  private String promotionEndTime;
//  private String config;
//  private Integer promotionType;
//  private String couponStartTime;
//  private String couponEndTime;
//  private String couponSuitUser;
//  private Integer couponFlag;
//  private String couponStock;
//  private String couponStatus;
//  private String keyWords;
//  /**
//   * 最大的自购赚，能够返现的部分。用于奖励排序 cashReturnTotal * 身份返现比例，即自购赚的金额
//   */
//  private Float cashReturnTotal;
//  /**
//   * 索引类型
//   */
//  private transient String searchType;
//
//
//}
