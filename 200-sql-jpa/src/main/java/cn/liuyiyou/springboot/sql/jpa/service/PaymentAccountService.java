package cn.liuyiyou.springboot.sql.jpa.service;

import cn.liuyiyou.springboot.sql.jpa.entity.PaymentAccount;
import cn.liuyiyou.springboot.sql.jpa.repository.PaymentAccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

/**
 * @author: liuyiyou.cn
 * @date: 2020/12/2
 * @version: V1.0
 */
@Service
@RequiredArgsConstructor
public class PaymentAccountService {

    private final PaymentAccountRepository paymentAccountRepository;

    @Modifying
    public PaymentAccount update(PaymentAccount paymentAccount) {
        final PaymentAccount result = paymentAccountRepository.save(paymentAccount);
        return result;
    }
}
