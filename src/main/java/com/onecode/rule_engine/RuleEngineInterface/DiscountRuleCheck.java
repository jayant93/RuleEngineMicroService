package com.onecode.rule_engine.RuleEngineInterface;

import com.onecode.rule_engine.model.DiscountRules;
import com.onecode.rule_engine.model.PartnerTransaction;

public interface DiscountRuleCheck {

	public boolean isValid(DiscountRules rule);

	public boolean isValid(DiscountRules currentRule, PartnerTransaction partnerTransaction);
	
}
