package com.onecode.rule_engine.service;

import java.util.Optional;

import com.onecode.rule_engine.responses.RuleEngineResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.onecode.rule_engine.DiscountRulesClasses.FixedDiscountRule;
import com.onecode.rule_engine.DiscountRulesClasses.IncrementalDiscountRule;
import com.onecode.rule_engine.DiscountRulesClasses.PercentageBasedDiscountRule;
import com.onecode.rule_engine.model.DiscountRules;
import com.onecode.rule_engine.model.PartnerTransaction;

@Component
public class CalculatingDiscount {

	@Autowired
	FixedDiscountRule FixedCommission;
	
	@Autowired
	PercentageBasedDiscountRule PercentageBasedCommmission;
	
	@Autowired
	IncrementalDiscountRule incrementalCommission;
	
	@Autowired
	RuleEngineResponse response;
	
	public RuleEngineResponse CalculateCommission(DiscountRules rule,Optional<PartnerTransaction> partner_transaction)
	{
		if(rule.getDiscountType().equalsIgnoreCase("Percentage")) {
			response = PercentageBasedCommmission.PercentageCommission(rule, partner_transaction);
		}
//		if(rule.getDiscountType().equalsIgnoreCase("Incremental")) {
//			response = incrementalCommission.IncrementalCommission(rule, partner_transaction);
//		}
		else if(rule.getDiscountType().equalsIgnoreCase("Fixed")) {
			response = FixedCommission.FixedCommission(rule, partner_transaction);
		}
		return response;
	}
}
