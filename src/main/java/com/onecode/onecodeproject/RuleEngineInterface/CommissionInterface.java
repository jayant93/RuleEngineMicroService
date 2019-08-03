package com.onecode.onecodeproject.RuleEngineInterface;

import java.util.List;
import java.util.Optional;

import com.onecode.onecodeproject.model.DiscountRules;
import com.onecode.onecodeproject.model.PartnerTransaction;
import com.onecode.onecodeproject.responses.RuleEngineResponse;

public interface CommissionInterface {

	//Method For fixed commission
	public RuleEngineResponse FixedCommission(DiscountRules rules,Optional<PartnerTransaction> partner_transaction);
	
	//Method for commission based on percentage
	public RuleEngineResponse PercentageCommission(DiscountRules rules,Optional<PartnerTransaction> partner_transaction);

	//Method for commission based on Increment
		public RuleEngineResponse IncrementalCommission(DiscountRules rules,Optional<PartnerTransaction> partner_transaction);
		
}
