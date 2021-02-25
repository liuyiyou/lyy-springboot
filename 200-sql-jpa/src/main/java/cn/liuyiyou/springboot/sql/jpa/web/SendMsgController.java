//package cn.liuyiyou.springboot.sql.jpa.web;
//
//import com.ngnis.walle.api.BaseResult;
//import com.ngnis.walle.api.GroupMessageDTO;
//import com.ngnis.walle.api.WalleClient;
//import com.ngnis.walle.api.WalleConfig;
//import com.ngnis.walle.api.WalleHttpClient;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//
///**
// * @author: liuyiyou.cn
// * @date: 2020/12/20
// * @version: V1.0
// */
//@RestController
//public class SendMsgController {
//
//    @GetMapping("/send")
//    public void test() {
//        WalleConfig config = WalleConfig.builder()
//            .endPoint("http://walle.yanglaoban.com")
//            .accessKey("8IUBHmY988A8OJwL")
//            .secretKey("tg8dJNtSRqpEeFjhmWIYLkuG")
//            .build();
//        WalleClient walleClient = new WalleHttpClient(config);
//        GroupMessageDTO messageDTO = new GroupMessageDTO();
//        messageDTO.setBoardCode("order_template_sales_about_2_hour");
//        messageDTO.setData(null);
//// 发送请求
//        BaseResult result = walleClient.sendGroupMessage(messageDTO);
//        System.out.println(result);
//    }
//}
