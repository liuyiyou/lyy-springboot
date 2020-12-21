package cn.liuyiyou.springboot.sql.jpa.web;

import com.alibaba.fastjson.JSONObject;
import com.ngnis.walle.api.BaseResult;
import com.ngnis.walle.api.GroupMessageDTO;
import com.ngnis.walle.api.WalleClient;
import com.ngnis.walle.api.WalleConfig;
import com.ngnis.walle.api.WalleHttpClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: liuyiyou.cn
 * @date: 2020/12/20
 * @version: V1.0
 */
@RestController
public class SendMsgController {

    @GetMapping("/send")
    public void test() {
        WalleConfig config = WalleConfig.builder()
            .endPoint("http://127.0.0.1:7001")
            .accessKey("8IUBHmY988A8OJwL")
            .secretKey("tg8dJNtSRqpEeFjhmWIYLkuG")
            .build();
// 创建 WalleClient
        WalleClient walleClient = new WalleHttpClient(config);
// 设置请求参数
        GroupMessageDTO messageDTO = new GroupMessageDTO();
// 模板编号
        messageDTO.setBoardCode("order_template_sales_about_2_hour");
// 携带的数据
        JSONObject data = new JSONObject();
        data.put("orderCount", "2");
        data.put("orderAmount", "123");
        data.put("newUserCount", "11");
        data.put("monthUpgradeCount", "13");
        data.put("yearUpgradeCount", "12");
        data.put("realPayShopAmout", "123");
        data.put("realPxAmout", "12.35");
        messageDTO.setData(data);
// 发送请求
        BaseResult result = walleClient.sendGroupMessage(messageDTO);
        System.out.println(result);
    }
}
