package com.onecode.rule_engine.DiscountRulesClasses;


import java.util.Optional;
import com.onecode.rule_engine.model.DiscountRules;
import com.onecode.rule_engine.model.PartnerTransaction;
import com.onecode.rule_engine.responses.RuleEngineResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.onecode.rule_engine.RuleEngineInterface.CommissionProcessor;

@Component
public class FlatCommission extends CommissionProcessor{

@Autowired
RuleEngineResponse response;
	
	public RuleEngineResponse CalculateCommission(DiscountRules rule, Optional<PartnerTransaction> partner_transaction) {
		//Fixed Earnings
		response = new RuleEngineResponse(rule.getPartnerDiscount()-(rule.getPartnerDiscount()*10)/100,
				(rule.getPartnerDiscount()*10)/100,"success","User Gets a fixed Discount");
		return response;
	}

		
}
