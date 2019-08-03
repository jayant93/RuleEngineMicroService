package com.onecode.onecodeproject.RuleEngineInterface;

import java.util.List;
import java.util.Optional;

import com.onecode.onecodeproject.model.DiscountRules;
import com.onecode.onecodeproject.model.PartnerTransaction;

public interface CheckCaseInterface {

	public boolean checkForTransactionId(Optional<PartnerTransaction> partner_transaction);
	
	public boolean checkForPartnerId(Optional<PartnerTransaction> partner_transaction);
	
	public boolean CheckForDiscountRule(Optional<PartnerTransaction> partner_transaction);
	
	public boolean CheckForDiscountRuleAmbiquity(List<DiscountRules> rules);
	
}
