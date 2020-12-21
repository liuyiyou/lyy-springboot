package cn.liuyiyou.boot.temp;

import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: liuyiyou.cn
 * @date: 2020/12/13
 * @version: V1.0
 */
@NoArgsConstructor
@Data
public class Response {

    private String merchant_order_id;

    private String sign;

    private int generate_fail_type;

    private String merchant_id;

    private String ret_msg;

    private int is_success;

    private String notice_code;

    private List<Error_sku_list> error_sku_list ;

    private String ret_code;

    private String sign_type;

    private String order_id;
    /**
     * biz_order_id : F6077609513482605
     * express_list : [{"express_code":"yunda","express_company":"韵达快递","express_order":"7700190387995","sku_list":[{"deliver_num":1,"package_num":1,"sku_code":"MZGHHSS00002213-Z"}]}]
     */

    private String biz_order_id;
    private List<ExpressListReponse> express_list;

    public void setMerchant_order_id(String merchant_order_id){
        this.merchant_order_id = merchant_order_id;
    }
    public String getMerchant_order_id(){
        return this.merchant_order_id;
    }
    public void setSign(String sign){
        this.sign = sign;
    }
    public String getSign(){
        return this.sign;
    }
    public void setGenerate_fail_type(int generate_fail_type){
        this.generate_fail_type = generate_fail_type;
    }
    public int getGenerate_fail_type(){
        return this.generate_fail_type;
    }
    public void setMerchant_id(String merchant_id){
        this.merchant_id = merchant_id;
    }
    public String getMerchant_id(){
        return this.merchant_id;
    }
    public void setRet_msg(String ret_msg){
        this.ret_msg = ret_msg;
    }
    public String getRet_msg(){
        return this.ret_msg;
    }
    public void setIs_success(int is_success){
        this.is_success = is_success;
    }
    public int getIs_success(){
        return this.is_success;
    }
    public void setNotice_code(String notice_code){
        this.notice_code = notice_code;
    }
    public String getNotice_code(){
        return this.notice_code;
    }
    public void setError_sku_list(List<Error_sku_list> error_sku_list){
        this.error_sku_list = error_sku_list;
    }
    public List<Error_sku_list> getError_sku_list(){
        return this.error_sku_list;
    }
    public void setRet_code(String ret_code){
        this.ret_code = ret_code;
    }
    public String getRet_code(){
        return this.ret_code;
    }
    public void setSign_type(String sign_type){
        this.sign_type = sign_type;
    }
    public String getSign_type(){
        return this.sign_type;
    }
    public void setOrder_id(String order_id){
        this.order_id = order_id;
    }
    public String getOrder_id(){
        return this.order_id;
    }

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


    class Error_sku_list {
        private int buy_num;

        private String channel_discount_amount;

        private int package_num;

        private int price_type;

        private String sku_code;

        private String sku_discount_amount;

        private String sku_pay_amount;

        private String sku_price;

        private String sku_tax_amount;

        public void setBuy_num(int buy_num){
            this.buy_num = buy_num;
        }
        public int getBuy_num(){
            return this.buy_num;
        }
        public void setChannel_discount_amount(String channel_discount_amount){
            this.channel_discount_amount = channel_discount_amount;
        }
        public String getChannel_discount_amount(){
            return this.channel_discount_amount;
        }
        public void setPackage_num(int package_num){
            this.package_num = package_num;
        }
        public int getPackage_num(){
            return this.package_num;
        }
        public void setPrice_type(int price_type){
            this.price_type = price_type;
        }
        public int getPrice_type(){
            return this.price_type;
        }
        public void setSku_code(String sku_code){
            this.sku_code = sku_code;
        }
        public String getSku_code(){
            return this.sku_code;
        }
        public void setSku_discount_amount(String sku_discount_amount){
            this.sku_discount_amount = sku_discount_amount;
        }
        public String getSku_discount_amount(){
            return this.sku_discount_amount;
        }
        public void setSku_pay_amount(String sku_pay_amount){
            this.sku_pay_amount = sku_pay_amount;
        }
        public String getSku_pay_amount(){
            return this.sku_pay_amount;
        }
        public void setSku_price(String sku_price){
            this.sku_price = sku_price;
        }
        public String getSku_price(){
            return this.sku_price;
        }
        public void setSku_tax_amount(String sku_tax_amount){
            this.sku_tax_amount = sku_tax_amount;
        }
        public String getSku_tax_amount(){
            return this.sku_tax_amount;
        }

    }
}
