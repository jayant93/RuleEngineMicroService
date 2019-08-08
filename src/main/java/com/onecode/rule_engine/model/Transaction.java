package com.onecode.rule_engine.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;

@Component
@Entity
@Table(name = "transaction")
@JsonIgnoreProperties(value = {"updatedAt","createdAt","deleatedAt"},allowGetters = true)
public class Transaction implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "partner_id")
    @NotNull
    private Long partnerId;

    @Column(name = "user_id")
    @NotNull
    private Long userId;

    @Column(name = "partner_transaction_id")
    @NotNull
    private Long partnerTransactionId;

    @Column(name = "discount_rule_id")
    @NotNull
    private  Long dicountRuleId;

    @Column(name = "amount")
    @NotNull
    private  Double amount;

    @Column(name = "payout")
    private  Double payOut;

    @Column(name = "status")
    @NotNull
    private  String status;

    @Column(name = "parent_id",length = 200)
    private String parent_id;

    
   
	public String getParent_id() {
		return parent_id;
	}

	public void setParent_id(String parent_id) {
		this.parent_id = parent_id;
	}

	@Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    @Column(name = "deleated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date deleatedAt;

    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPartnerId() {
        return partnerId;
    }

    public void setPartnerId(Long partnerId) {
        this.partnerId = partnerId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getPartnerTransactionId() {
        return partnerTransactionId;
    }

    public void setPartnerTransactionId(Long partnerTransactionId) {
        this.partnerTransactionId = partnerTransactionId;
    }

    public Long getDicountRuleId() {
        return dicountRuleId;
    }

    public void setDicountRuleId(Long dicountRuleId) {
        this.dicountRuleId = dicountRuleId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Double getPayOut() {
        return payOut;
    }

    public void setPayOut(Double payOut) {
        this.payOut = payOut;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Date getDeleatedAt() {
        return deleatedAt;
    }

    public void setDeleatedAt(Date deleatedAt) {
        this.deleatedAt = deleatedAt;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
