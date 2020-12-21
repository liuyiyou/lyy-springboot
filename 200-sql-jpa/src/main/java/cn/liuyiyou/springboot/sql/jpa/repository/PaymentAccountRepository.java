package cn.liuyiyou.springboot.sql.jpa.repository;

import cn.liuyiyou.springboot.sql.jpa.entity.PaymentAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * @author liuyiyou 2020-07-19
 */
@Repository
public interface PaymentAccountRepository extends JpaRepository<PaymentAccount, String> {

    PaymentAccount findByPaymentAppNameAndStatusAndTenantId(String paymentAppName, Boolean status, String tenantId);

    PaymentAccount findByPaymentAppNameAndStatusAndChannelAndTenantId(String paymentAppName, Boolean status, String channel, String tenantId);

    PaymentAccount findByPaymentAppNameAndStatus(String paymentAppName, Boolean status);

    PaymentAccount findByPaymentAppNameAndStatusAndChannel(String paymentAppName, Boolean status, String channel);
}
