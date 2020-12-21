package cn.liuyiyou.springboot.sql.jpa.service;

import cn.liuyiyou.springboot.sql.jpa.entity.PaymentAccount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author: liuyiyou.cn
 * @date: 2020/12/2
 * @version: V1.0
 */
@SpringBootTest
class PaymentAccountServiceTest {

    @Autowired
    private PaymentAccountService paymentAccountService;

    @DisplayName("更新Null值")
    @Test
    void updateNull() {
        PaymentAccount paymentAccount = new PaymentAccount();
        paymentAccount.setId("PaymentAccount:ALIPAY:16");
        paymentAccount.setNotifyUrl(null);
        paymentAccountService.update(paymentAccount);
    }
}