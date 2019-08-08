package com.onecode.rule_engine.CheckClasses;

import com.onecode.rule_engine.RuleEngineInterface.DiscountRuleProcessor;
import com.onecode.rule_engine.model.DiscountRules;
import com.onecode.rule_engine.model.PartnerTransaction;

public class FlatRule implements DiscountRuleProcessor{

	boolean status = false;
	@Override
	public boolean isValid(DiscountRules rule) {
		// TODO Auto-generated method stub
		if(rule.getFlat().equals(true) && rule.getFlat()!=null) {
			status = true;
		}
		return status;
	}
	@Override
	public boolean isValid(DiscountRules currentRule, PartnerTransaction partnerTransaction) {
		// TODO Auto-generated method stub
		return false;
	}

	
}
