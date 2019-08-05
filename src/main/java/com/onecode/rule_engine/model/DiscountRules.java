package com.onecode.rule_engine.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;

@Component
@Entity
@Table(name = "discountrules")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt","deleatedAt","expiresAt"},
        allowGetters = true)
//entity to describe the various discount rules
public class DiscountRules implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="partnerId", referencedColumnName = "id")
    private Partner partner;

    @Column(name = "rule_rank")
    private Integer ruleRank;

    @Column(name = "priority")
    private Integer priority;


    @Column(name = "is_active")
    @NotBlank
    private Boolean isActive;

    @Column( name = "name",length = 225)
    @NotBlank
    private String name;

    @Column(name = "description",length = 225)
    private String description;

    @Column(name = "partner_discount")
    private Double partnerDiscount;

    @Column(name = "partner_discount_type")
    private String discountType;

    @Column(name = "partner_user_discount")
    private Double partnerUserDiscount;


    @Column(name = "partner_user_discount_type")
    private String partnerUserdiscountType;


    @Column(name = "is_flat")
    private Boolean isFlat;


    @Column(name = "is_count_based")
    @NotBlank
    private Boolean isCountBased;


    @Column(name = "is_new")
    @NotBlank
    private Boolean isNew;

    @Column(name = "is_time_based")
    @NotBlank
    private Boolean isTimeBased;

    @Column(name = "is_logical_or")
    @NotBlank
    private Boolean isLogicalOr;

    @Column(name = "min_transaction_count",length = 10)
    private Integer minTransactionCount;

    @Column(name = "max_transaction_count",length = 10)
    private Integer maxTransactionCount;


    @Column(name = "min_time_elapsed",length = 20)
    private Double minTimeElapsed;


    @Column(name = "max_time_elapsed",length = 20)
    private Double maxTimeElapsed;

    @Column(name = "min_transaction_amount",length = 10)
    private Double minTransactionAmount;

    @Column(name = "max_discount_amount",length = 10)
    private Double maxDiscountAmount;

    @Column(name = "category_id",length = 10)
    private Long categoryId;

    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createdAt;

    @Column( name = "updated_at",nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date updatedAt;

    @Column( name = "deleated_at",nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date deleatedAt;

    @Column( name = "expires_at",nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date expiresAt;

    public Partner getPartner() {
        return partner;
    }

    public void setPartner(Partner partner) {
        this.partner = partner;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getCountBased() {
        return isCountBased;
    }

    public void setCountBased(Boolean countBased) {
        isCountBased = countBased;
    }

    public Boolean getIsNew() {
        return isNew;
    }

    public void setIsNew(Boolean aNew) {
        isNew = aNew;
    }

    public Boolean getTimeBased() {
        return isTimeBased;
    }

    public void setTimeBased(Boolean timeBased) {
        isTimeBased = timeBased;
    }

    public Boolean getiLogicalOr() {
        return isLogicalOr;
    }

    public void setiLogicalOr(Boolean iLogicalOr) {
        this.isLogicalOr = iLogicalOr;
    }

    public Integer getMinTransactionCount() {
        return minTransactionCount;
    }

    public void setMinTransactionCount(Integer minTransactionCount) {
        this.minTransactionCount = minTransactionCount;
    }

    public Integer getMaxTransactionCount() {
        return maxTransactionCount;
    }

    public void setMaxTransactionCount(Integer maxTransactionCount) {
        this.maxTransactionCount = maxTransactionCount;
    }

    public Double getMinTimeElapsed() {
        return minTimeElapsed;
    }

    public void setMinTimeElapsed(Double minTimeElapsed) {
        this.minTimeElapsed = minTimeElapsed;
    }

    public Double getMaxTimeElapsed() {
        return maxTimeElapsed;
    }

    public void setMaxTimeElapsed(Double maxTimeElapsed) {
        this.maxTimeElapsed = maxTimeElapsed;
    }

    public Double getMinTransactionAmount() {
        return minTransactionAmount;
    }

    public void setMinTransactionAmount(Double minTransactionAmount) {
        this.minTransactionAmount = minTransactionAmount;
    }

    public Double getMaxDiscountAmount() {
        return maxDiscountAmount;
    }

    public void setMaxDiscountAmount(Double maxDiscountAmount) {
        this.maxDiscountAmount = maxDiscountAmount;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
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

    public Date getExpiresAt() {
        return expiresAt;
    }

    public void setExpiresAt(Date expiresAt) {
        this.expiresAt = expiresAt;
    }

    public Integer getRuleRank() {
        return ruleRank;
    }

    public void setRuleRank(Integer ruleRank) {
        this.ruleRank = ruleRank;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public Boolean getLogicalOr() {
        return isLogicalOr;
    }

    public void setLogicalOr(Boolean logicalOr) {
        isLogicalOr = logicalOr;
    }


    public Boolean getFlat() { return isFlat; }

    public void setFlat(Boolean flat) { isFlat = flat; }

    public Double getPartnerDiscount() {
        return partnerDiscount;
    }

    public void setPartnerDiscount(Double partnerDiscount) {
        this.partnerDiscount = partnerDiscount;
    }
    public String getDiscountType() {
        return discountType;
    }

    public void setDiscountType(String discountType) {
        this.discountType = discountType;
    }

    public Double getPartnerUserDiscount() {
        return partnerUserDiscount;
    }

    public void setPartnerUserDiscount(Double partnerUserDiscount) {
        this.partnerUserDiscount = partnerUserDiscount;
    }

    public String getPartnerUserdiscountType() {
        return partnerUserdiscountType;
    }

    public void setPartnerUserdiscountType(String partnerUserdiscountType) {
        this.partnerUserdiscountType = partnerUserdiscountType;
    }
}
