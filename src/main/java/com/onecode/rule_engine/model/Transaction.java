package com.onecode.rule_engine.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

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
    private String partnerTransactionId;

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

    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    @Column(name = "deleated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date deleatedAt;

    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
}
