package com.onecode.rule_engine.CheckClasses;

import com.onecode.rule_engine.RuleEngineInterface.DiscountRuleCheck;
import com.onecode.rule_engine.model.DiscountRules;
import com.onecode.rule_engine.model.PartnerTransaction;

public class isTimeBased implements DiscountRuleCheck{

	@Override
	public boolean isValid(DiscountRules rule) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isValid(DiscountRules currentRule, PartnerTransaction partnerTransaction) {
		// TODO Auto-generated method stub
		return false;
	}

}
