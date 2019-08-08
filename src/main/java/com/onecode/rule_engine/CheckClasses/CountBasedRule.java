package com.onecode.rule_engine.CheckClasses;

import org.springframework.beans.factory.annotation.Autowired;
import com.onecode.rule_engine.RuleEngineInterface.DiscountRuleProcessor;
import com.onecode.rule_engine.model.DiscountRules;
import com.onecode.rule_engine.model.PartnerTransaction;
import com.onecode.rule_engine.repository.PartnerTransactionRepository;

public class CountBasedRule implements DiscountRuleProcessor{

	@Autowired
	PartnerTransactionRepository partner_transaction_repo;

	boolean status = false;
	
	@Override
	public boolean isValid(DiscountRules rule) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isValid(DiscountRules currentRule, PartnerTransaction partnerTransaction) {
		Long transactionCount = partner_transaction_repo.findNumberOfTransactions
				(partnerTransaction.getId(), partnerTransaction.getPartnerUserHash());
		

		if (transactionCount <= currentRule.getMaxTransactionCount()
			&& transactionCount >= currentRule.getMinTransactionCount()) {
			status = true;
		}
		return status;
	}

}
