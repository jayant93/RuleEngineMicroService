package com.onecode.rule_engine.service;

import java.util.Optional;
import com.onecode.rule_engine.responses.RuleEngineResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.onecode.rule_engine.DiscountRulesClasses.FlatCommission;
import com.onecode.rule_engine.DiscountRulesClasses.PercentageCommission;
import com.onecode.rule_engine.RuleEngineInterface.CommissionProcessor;
import com.onecode.rule_engine.model.DiscountRules;
import com.onecode.rule_engine.model.PartnerTransaction;

@Component
public class CalculatingDiscount {

	PercentageCommission percentageCommission;
	
	FlatCommission flatCommission;
	
	@Autowired
	RuleEngineResponse response;
	
	public RuleEngineResponse CalculateCommission(DiscountRules rule,Optional<PartnerTransaction> partner_transaction)
	{
						try {
							if(rule.getDiscountType().equalsIgnoreCase("Percentage")) {
										response = percentageCommission.CalculateCommission(rule, partner_transaction);
										}

									else if(rule.getDiscountType().equalsIgnoreCase("Fixed")) {
										response = flatCommission.CalculateCommission(rule, partner_transaction);
									}
						} catch (Exception e) {
							e.printStackTrace();
						}
		
				
					return response;
	}
}
