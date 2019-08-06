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
				 filterDiscountRules(partner_transaction);
//						,transaction.getAmount(),transaction.getIsNewUser()
//						,Number_of_transactions);
	});
		
		return rules;
	}
	
	Integer val = 0;

	public void filterDiscountRules(Optional<PartnerTransaction> partner_transaction) {
		partner_transaction.ifPresent(partnerTransaction -> {
			// if there are more rules available to check
			//if (rules.size() >= 1) {

				DiscountRules currentRule = rules.get(val);

				if (currentRule.getFlat() != null && currentRule.getFlat()) {
					setValidRule();
					return;
				}

				// if the rule is based on new user or old user check
				if(currentRule.getIsNew() != null) {
					// whether the transaction has a value for NewUser
					// and if it matches that of the rule
					if(partnerTransaction.getIsNewUser() != null
							&& currentRule.getIsNew().equals(partnerTransaction.getIsNewUser())) {
						setValidRule();
						return;
					}
				}

				// if the rule is based on count
				if (currentRule.getCountBased() != null) {
					Long transactionCount = partner_transaction_repo.findNumberOfTransactions
							(partnerTransaction.getId(), partnerTransaction.getPartnerUserHash());
					

					if (transactionCount <= currentRule.getMaxTransactionCount()
						&& transactionCount >= currentRule.getMinTransactionCount()) {
						setValidRule();
						return;
					}
				}

				// if rule passes nothing remove it and make a recursive call
				rules.remove(0);
				val++;
				filterDiscountRules(partner_transaction);
			//}
		});
	}
	
	// Removes all other rules if one qualifying rule is found
		private void setValidRule() {
			DiscountRules validRule = rules.get(val);
			rules.clear();
			rules.add(validRule);
		}
		
	
}
