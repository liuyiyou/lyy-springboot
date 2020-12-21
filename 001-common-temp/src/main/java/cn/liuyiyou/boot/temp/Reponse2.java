package cn.liuyiyou.boot.temp;

import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: liuyiyou.cn
 * @date: 2020/12/14
 * @version: V1.0
 */
@NoArgsConstructor
@Data
public class Reponse2 {


    /**
     * notice_code : deliver_order_notice
     * merchant_order_id : 12121320414
     * sign : d52f73268d7a90fbdbabe3b56505c25f
     * ret_msg : 处理成功
     * ret_code : 200
     * sign_type : MD5
     * order_id : XS6077384042602548
     * biz_order_id : F6077609513482605
     * express_list : [{"express_code":"yunda","express_company":"韵达快递","express_order":"7700190387995","sku_list":[{"deliver_num":1,"package_num":1,"sku_code":"MZGHHSS00002213-Z"}]}]
     */

    private String notice_code;
    private String merchant_order_id;
    private String sign;
    private String ret_msg;
    private String ret_code;
    private String sign_type;
    private String order_id;
    private String biz_order_id;
    private List<ExpressListReponse> express_list;

    @NoArgsConstructor
    @Data
    public static class ExpressListReponse {

        /**
         * express_code : yunda
         * express_company : 韵达快递
         * express_order : 7700190387995
         * sku_list : [{"deliver_num":1,"package_num":1,"sku_code":"MZGHHSS00002213-Z"}]
         */

        private String express_code;
        private String express_company;
        private String express_order;
        private List<SkuListReponse> sku_list;

        @NoArgsConstructor
        @Data
        public static class SkuListReponse {

            /**
             * deliver_num : 1
             * package_num : 1
             * sku_code : MZGHHSS00002213-Z
             */

            private int deliver_num;
            private int package_num;
            private String sku_code;
        }
    }
}
