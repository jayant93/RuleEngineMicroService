package com.onecode.rule_engine.RuleEngineInterface;

import java.util.Optional;

import com.onecode.rule_engine.model.DiscountRules;
import com.onecode.rule_engine.model.PartnerTransaction;
import com.onecode.rule_engine.responses.RuleEngineResponse;

public interface CommissionInterface {

	//Method For fixed commission
	public RuleEngineResponse FixedCommission(DiscountRules rules, Optional<PartnerTransaction> partner_transaction);
	
	//Method for commission based on percentage
	public RuleEngineResponse PercentageCommission(DiscountRules rules,Optional<PartnerTransaction> partner_transaction);

	//Method for commission based on Increment
		public RuleEngineResponse IncrementalCommission(DiscountRules rules,Optional<PartnerTransaction> partner_transaction);
		
}
