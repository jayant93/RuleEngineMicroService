package com.onecode.rule_engine.CheckClasses;

import java.util.List;
import java.util.Optional;

import com.onecode.rule_engine.RuleEngineInterface.CheckCaseInterface;
import com.onecode.rule_engine.model.DiscountRules;
import com.onecode.rule_engine.model.PartnerTransaction;
import org.springframework.stereotype.Component;

@Component
public class DiscountRulesAmbiquityCheck /*implements CheckCaseInterface */{
	
	Boolean status = false;

	/*
	 * @Override public boolean CheckForDiscountRuleAmbiquity(List<DiscountRules>
	 * rules) { if(rules.size() == 1) { status = true; } return status; }
	 */


}
