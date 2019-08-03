package com.onecode.onecodeproject.DiscountRulesClasses;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.onecode.onecodeproject.RuleEngineInterface.CommissionInterface;
import com.onecode.onecodeproject.model.DiscountRules;
import com.onecode.onecodeproject.model.PartnerTransaction;
import com.onecode.onecodeproject.responses.RuleEngineResponse;

@Component
public class FixedDiscountRule implements CommissionInterface{

@Autowired
RuleEngineResponse response;
	
	@Override
	public RuleEngineResponse FixedCommission(DiscountRules rule,Optional<PartnerTransaction> partner_transaction) {
		//Fixed Earnings
		response = new RuleEngineResponse(rule.getPartnerDiscount(),
				(rule.getPartnerDiscount()*10)/100,"success","User Gets a fixed Discount");
		return response;
	}

	@Override
	public RuleEngineResponse PercentageCommission(DiscountRules rules,Optional<PartnerTransaction> partner_transaction) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RuleEngineResponse IncrementalCommission(DiscountRules rules,
			Optional<PartnerTransaction> partner_transaction) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
