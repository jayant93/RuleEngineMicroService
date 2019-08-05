package com.onecode.rule_engine.RuleEngineInterface;

import java.util.List;
import java.util.Optional;

import com.onecode.rule_engine.model.DiscountRules;
import com.onecode.rule_engine.model.PartnerTransaction;

public interface CheckCaseInterface {

	/*
	 * public boolean checkForTransactionId(Optional<PartnerTransaction>
	 * partner_transaction);
	 * 
	 * public boolean checkForPartnerId(Optional<PartnerTransaction>
	 * partner_transaction);
	 * 
	 * public boolean CheckForDiscountRule(Optional<PartnerTransaction>
	 * partner_transaction);
	 */
	
	public boolean validate(Optional<PartnerTransaction> partner_transaction);
	
//	public boolean CheckForDiscountRuleAmbiquity(List<DiscountRules> rules);
	
}
