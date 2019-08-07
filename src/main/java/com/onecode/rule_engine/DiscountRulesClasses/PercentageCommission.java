package com.onecode.rule_engine.DiscountRulesClasses;

import java.util.Optional;

import com.onecode.rule_engine.model.DiscountRules;
import com.onecode.rule_engine.model.PartnerTransaction;
import com.onecode.rule_engine.responses.RuleEngineResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.onecode.rule_engine.RuleEngineInterface.CommissionInterface;

@Component
public class PercentageBasedDiscountRule implements CommissionInterface {

	@Autowired
	RuleEngineResponse response;
	
	Double Temp;
	

	@Override
	public RuleEngineResponse CalculateCommission(DiscountRules rule,Optional<PartnerTransaction> partner_transaction) {
		partner_transaction.ifPresent(tran ->{
			 Temp = (tran.getAmount() * rule.getPartnerDiscount()) /100;	
		});
			
		response = new RuleEngineResponse(Temp,(Temp*10)/100,"success","User gets Percentage based commission");
		
		return response;
	}



}
