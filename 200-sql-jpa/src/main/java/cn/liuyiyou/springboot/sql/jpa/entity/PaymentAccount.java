package cn.liuyiyou.springboot.sql.jpa.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.time.Instant;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

/**
 * payment_account
 *
 * @author Tony Luo 2020-08-07
 */
@Data
@Entity
@Table(name = "payment_account")
@DynamicUpdate
public class PaymentAccount implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "id", length = 32)
    private String id;

    /**
     * 租户ID
     */
    @Column(name = "tenant_id", length = 32)
    private String tenantId;

    /**
     * 支付app名称:支付宝支付，微信支付
     */
    @Column(name = "payment_app_name", length = 45)
    private String paymentAppName;

    /**
     * 委托收款账号
     */
    @Column(name = "payment_app_account", length = 32)
    private String paymentAppAccount;

    /**
     * 委托收款子账号
     */
    @Column(name = "payment_app_child_account", length = 32)
    private String paymentAppChildAccount;

    @Column(name = "notify_url", length = 100)
    private String notifyUrl;

    @Column(name = "channel", length = 21)
    private String channel;

    /**
     * 扩展信息JSON格式(私钥、密钥)
     */
    @Column(name = "extra")
    private String extra;

    /**
     * 备注
     */
    @Column(name = "remark", length = 100)
    private String remark;

    /**
     * 状态（1:启用，0:禁用）
     */
    @Column(name = "status")
    private Boolean status;

    @CreatedBy
    @Column(name = "created_by", nullable = false, length = 50, updatable = false)
    @JsonIgnore
    private String createdBy;

    @CreatedDate
    @Column(name = "created_date", updatable = false)
    @JsonIgnore
    private Instant createdDate = Instant.now();

    @LastModifiedBy
    @Column(name = "last_modified_by", length = 50)
    @JsonIgnore
    private String lastModifiedBy;

    @LastModifiedDate
    @Column(name = "last_modified_date")
    @JsonIgnore
    private Instant lastModifiedDate = Instant.now();

}
