package com.onecode.rule_engine.RuleEngine;

import java.util.List;
import java.util.Optional;

import com.onecode.rule_engine.model.DiscountRules;
import com.onecode.rule_engine.model.PartnerTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.onecode.rule_engine.repository.DiscountRulesRepository;
import com.onecode.rule_engine.repository.PartnerTransactionRepository;

@Component
public class FetchDiscountRules {

	@Autowired
	DiscountRules rule;
	
	@Autowired
	List<DiscountRules> rules;
	
	@Autowired
	DiscountRulesRepository rule_repo;
	
	
	@Autowired
	PartnerTransactionRepository partner_transaction_repo;

//	Long Number_of_transactions;
	
	public List<DiscountRules> getDiscountRule(Optional<PartnerTransaction> partner_transaction) {
		
		partner_transaction.ifPresent(transaction -> {
//				Number_of_transactions = partner_transaction_repo.findNumberOfTransactions(transaction.getId(), transaction.getPartnerUserHash());
				rules = rule_repo.findRule(true,transaction.getPartnerId());
//						,transaction.getAmount(),transaction.getIsNewUser()
//						,Number_of_transactions);
	});
		
		return rules;
	}
}
