package com.onecode.rule_engine.repository;

import com.onecode.rule_engine.model.PartnerTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PartnerTransactionRepository extends JpaRepository<PartnerTransaction,Long> {

	@Query(value="Select pt from partner_transaction where partner_id = :partner_id",nativeQuery = true)
	PartnerTransaction findOne(@Param("partner_id") Long id);

	@Query(value="Select count(id) as num from partner_transaction where partner_id = :partner_id and partner_user_hash = :partner_user_hash",nativeQuery=true)
	Long findNumberOfTransactions(@Param("partner_id") Long id, @Param("partner_user_hash") String hash);

	@Query(value="Select * from partner_transaction where id = :id and parent_id IS NOT NULL",nativeQuery = true)
	PartnerTransaction getTransactionIfParentPresent(@Param("id")Long id);


}
