package com.onecode.rule_engine.CheckClasses;

import com.onecode.rule_engine.RuleEngineInterface.DiscountRuleProcessor;
import com.onecode.rule_engine.model.DiscountRules;
import com.onecode.rule_engine.model.PartnerTransaction;

public class TimeBasedRule implements DiscountRuleProcessor{

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
