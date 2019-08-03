package com.onecode.onecodeproject.DiscountRulesClasses;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.onecode.onecodeproject.RuleEngineInterface.CommissionInterface;
import com.onecode.onecodeproject.model.DiscountRules;
import com.onecode.onecodeproject.model.PartnerTransaction;
import com.onecode.onecodeproject.responses.RuleEngineResponse;

@Component
public class IncrementalDiscountRule  implements CommissionInterface{

	@Override
	public RuleEngineResponse FixedCommission(DiscountRules rules, Optional<PartnerTransaction> partner_transaction) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RuleEngineResponse PercentageCommission(DiscountRules rules,
			Optional<PartnerTransaction> partner_transaction) {
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
