package com.onecode.onecodeproject.DiscountRulesClasses;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.onecode.onecodeproject.RuleEngineInterface.CommissionInterface;
import com.onecode.onecodeproject.model.DiscountRules;
import com.onecode.onecodeproject.model.PartnerTransaction;
import com.onecode.onecodeproject.responses.RuleEngineResponse;

@Component
public class PercentageBasedDiscountRule implements CommissionInterface {

	@Autowired
	RuleEngineResponse response;
	
	Double Temp;
	
	@Override
	public RuleEngineResponse FixedCommission(DiscountRules rules,Optional<PartnerTransaction> partner_transaction) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RuleEngineResponse PercentageCommission(DiscountRules rule,Optional<PartnerTransaction> partner_transaction) {
		partner_transaction.ifPresent(tran ->{
			 Temp = (tran.getAmount() * rule.getPartnerDiscount()) /100;	
		});
			
		response = new RuleEngineResponse(Temp - (Temp*10)/100,(Temp*10)/100,"success","User gets Percentage based commission");
		
		return response;
	}

	@Override
	public RuleEngineResponse IncrementalCommission(DiscountRules rules,
			Optional<PartnerTransaction> partner_transaction) {
		// TODO Auto-generated method stub
		return null;
	}


}
