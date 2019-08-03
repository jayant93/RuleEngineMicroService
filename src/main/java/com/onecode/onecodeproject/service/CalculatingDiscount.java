package com.onecode.onecodeproject.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.onecode.onecodeproject.DiscountRulesClasses.FixedDiscountRule;
import com.onecode.onecodeproject.DiscountRulesClasses.IncrementalDiscountRule;
import com.onecode.onecodeproject.DiscountRulesClasses.PercentageBasedDiscountRule;
import com.onecode.onecodeproject.model.DiscountRules;
import com.onecode.onecodeproject.model.PartnerTransaction;
import com.onecode.onecodeproject.responses.RuleEngineResponse;

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
		if(rule.getDiscountType().equalsIgnoreCase("Incremental")) {
			response = incrementalCommission.IncrementalCommission(rule, partner_transaction);
		}
		if(rule.getDiscountType().equalsIgnoreCase("Fixed")) {
			response = FixedCommission.FixedCommission(rule, partner_transaction);
		}
		return response;
	}
}
