package com.onecode.rule_engine.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Component
@Entity
@Table(name = "partner")
@JsonIgnoreProperties(value = {"createdAt", "updatedAt", "deleatedAt"},
        allowGetters = true)
//partner entity
public class Partner implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long partnerId;

    @Column(name = "logo",length = 1000)
    private String logo;

    @Column(name = "fullname",length = 225)
    private String fullname;

    @Column(name="description",length = 225)
    private String description;

    @Column(name="email")
    private String email;

    @Column(name = "comission",length = 20)
    private Double comission;

    @Column(name = "comission_type",length = 225)
    private String comission_type;

    @Column(name = "is_active")
    private Boolean isActive;

    @Column(name = "is_verifed")
    private Boolean isVerified;

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

    @JsonIgnore
    @OneToMany(mappedBy="partner",fetch = FetchType.EAGER,targetEntity = DiscountRules.class,
            cascade = CascadeType.ALL)
    private Set<DiscountRules> discountRules;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(unique = true,name = "user_id",referencedColumnName = "id")
    private OnecodeUser onecodeUser;

    public OnecodeUser getOnecodeUser() { return onecodeUser; }

    public void setOnecodeUser(OnecodeUser onecodeUser) { this.onecodeUser = onecodeUser; }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getComission() {
        return comission;
    }

    public void setComission(Double comission) {
        this.comission = comission;
    }

    public String getComission_type() {
        return comission_type;
    }

    public void setComission_type(String comission_type) {
        this.comission_type = comission_type;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
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

    public Long getPartnerId() {
        return partnerId;
    }

    public void setPartnerId(Long partnerId) {
        this.partnerId = partnerId;
    }

    public Set<DiscountRules> getDiscountRules() {
        return discountRules;
    }

    public void setDiscountRules(Set<DiscountRules> discountRules) {
        this.discountRules = discountRules;
    }


    public void setDeleatedAt(Date deleatedAt) {
        this.deleatedAt = deleatedAt;
    }

    public Boolean getVerified() {
        return isVerified;
    }

    public void setVerified(Boolean verified) {
        isVerified = verified;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
