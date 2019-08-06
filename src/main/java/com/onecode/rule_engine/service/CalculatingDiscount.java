package com.onecode.rule_engine.service;

import java.util.Optional;

import com.onecode.rule_engine.responses.RuleEngineResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.onecode.rule_engine.DiscountRulesClasses.FixedDiscountRule;
import com.onecode.rule_engine.DiscountRulesClasses.IncrementalDiscountRule;
import com.onecode.rule_engine.DiscountRulesClasses.PercentageBasedDiscountRule;
import com.onecode.rule_engine.RuleEngineInterface.CommissionInterface;
import com.onecode.rule_engine.model.DiscountRules;
import com.onecode.rule_engine.model.PartnerTransaction;

@Component
public class CalculatingDiscount {

	CommissionInterface Commission;
	
	@Autowired
	RuleEngineResponse response;
	
	public RuleEngineResponse CalculateCommission(DiscountRules rule,Optional<PartnerTransaction> partner_transaction)
	{
						if(rule.getDiscountType().equalsIgnoreCase("Percentage")) {
							Commission = new PercentageBasedDiscountRule();
									}

								else if(rule.getDiscountType().equalsIgnoreCase("Fixed")) {
									Commission = new FixedDiscountRule();
								}
		
					response = Commission.CalculateCommission(rule, partner_transaction);
					
					return response;
	}
}
