package com.onecode.onecodeproject.RuleEngine;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.onecode.onecodeproject.CheckClasses.DiscountRulesAmbiquityCheck;
import com.onecode.onecodeproject.model.DiscountRules;
import com.onecode.onecodeproject.model.PartnerTransaction;
import com.onecode.onecodeproject.repository.DiscountRulesRepository;
import com.onecode.onecodeproject.repository.PartnerTransactionRepository;
import com.onecode.onecodeproject.utils.RuleEngineChecks;

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
	
	Long Number_of_transactions;
	
	public List<DiscountRules> getDiscountRule(Optional<PartnerTransaction> partner_transaction) {
		
		partner_transaction.ifPresent(transaction -> {
				Number_of_transactions = partner_transaction_repo.findNumberOfTransactions(transaction.getId());
				rules = rule_repo.findRule(true,transaction.getPartnerId()
						,transaction.getAmount(),transaction.getIsNewUser()
						,Number_of_transactions);
	});
		
		return rules;
	}
}
