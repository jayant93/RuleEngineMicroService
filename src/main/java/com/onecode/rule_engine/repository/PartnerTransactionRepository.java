package com.onecode.rule_engine.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.onecode.rule_engine.model.PartnerTransaction;

@Repository
public interface PartnerTransactionRepository extends JpaRepository<PartnerTransaction,Long> {

	@Query(value="Select pt from partner_transaction where partner_id = :partner_id",nativeQuery = true)
	PartnerTransaction findOne(@Param("partner_id") Long id);

	@Query(value="Select count(id) as num from partner_transaction where partner_id = :partner_id",nativeQuery=true)
	Long findNumberOfTransactions(@Param("partner_id") Long id);


}
