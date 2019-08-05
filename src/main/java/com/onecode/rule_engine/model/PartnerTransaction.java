package com.onecode.rule_engine.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "partner_transaction")
@JsonIgnoreProperties(value = {"createdAt","updatedAt","deleatedAt"},
        allowGetters = true)
//partner transaction entity
public class PartnerTransaction implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "partner_id")
    @NotBlank
    @NotNull
    private Long partnerId;

    @Column(name = "user_id")
    @NotBlank
    @NotNull
    private  Long userId;

    @Column(name = "category_id")
    private  Long categoryId;

    @Column(name = "is_newuser")
    @NotNull
    private Boolean isNewUser;

    @Column(name = "status")
    @NotNull
    private String status;

    @Column(name = "amount")
    @NotNull
    private Double amount;

	@Column(name ="partner_transaction_id")
	@NotNull
	private  String patrnerTransactionId;

	@Column(name ="partner_user_hash")
	private  String partnerUserHash;

    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
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

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public Boolean getIsNewUser() {
		return isNewUser;
	}

	public void setIsNewUser(Boolean isNewUser) {
		this.isNewUser = isNewUser;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getPatrnerTransactionId() {
		return patrnerTransactionId;
	}

	public void setPatrnerTransactionId(String patrnerTransactionId) {
		this.patrnerTransactionId = patrnerTransactionId;
	}

	public String getPartnerUserHash() { return partnerUserHash; }

	public void setPartnerUserHash(String partnerUserHash) { this.partnerUserHash = partnerUserHash; }

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

	@Column( name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date updatedAt;

    @Column(name = "deleated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private  Date deleatedAt;


}
