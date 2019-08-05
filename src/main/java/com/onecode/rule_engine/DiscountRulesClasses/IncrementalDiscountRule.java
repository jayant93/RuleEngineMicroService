package com.onecode.rule_engine.DiscountRulesClasses;

import java.util.Optional;

import com.onecode.rule_engine.model.DiscountRules;
import com.onecode.rule_engine.model.PartnerTransaction;
import com.onecode.rule_engine.responses.RuleEngineResponse;
import org.springframework.stereotype.Component;

import com.onecode.rule_engine.RuleEngineInterface.CommissionInterface;

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
