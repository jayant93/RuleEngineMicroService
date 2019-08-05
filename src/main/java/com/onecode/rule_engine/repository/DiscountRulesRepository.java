package com.onecode.rule_engine.repository;

import com.onecode.rule_engine.model.DiscountRules;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
//discount rules repository for the one code user (ORM between our DiscountRules entity class and database )
@Repository
public interface DiscountRulesRepository extends JpaRepository<DiscountRules,Long> {
//    List<DiscountRules> findAllByIsActiveOrderByCreatedAt(Boolean isActive, Pageable pageable);
    List<DiscountRules> findAllByIsActiveAndIsActiveNotNull(Boolean isActive,Pageable pageable);
    List<DiscountRules> findAllByIsActive(Boolean isActive, Pageable pageable);
    
    //returns a List of all  Active DiscountRules
    @Query(value = "Select * from discountrules where is_active = :isactive "
    		+ "and partner_id = :partner_id"
    		+ " order by rule_rank desc",nativeQuery = true)
    List<DiscountRules> findAllByIsActive(@Param("isactive")Boolean isactive
    		,@Param("partner_id")Long Partner_id);
    
    
    //returns DiscountRules
    @Query(value = "Select * from discountrules "
    		+ "where "
    		+ " is_active = :isactive "
    		+ " and "
    		+ " partner_id = :partner_id"
//    		+ " and"
//    		+ " is_new = :isNewUser"
//    		+ " and"
//    		+ " :number_of_transaction > min_transaction_count"
//    		+ " and"
//    		+ " :number_of_transaction < max_transaction_count"
//    		+ " and"
//    		+ " :transaction_amount > min_transaction_amount"
    		+ " order by priority desc",nativeQuery = true)
    List<DiscountRules> findRule(@Param("isactive") Boolean isactive,
    						     @Param("partner_id") Long partner_id);
//    						     @Param("transaction_amount") Double transaction_amount,
//    						     @Param("isNewUser") Boolean isNewUser,
//    						     @Param("number_of_transaction") Long number_of_transactions);
    
    
}
