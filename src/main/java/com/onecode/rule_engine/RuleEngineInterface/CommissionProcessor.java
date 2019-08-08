package com.onecode.rule_engine.RuleEngineInterface;

import java.util.Optional;

import com.onecode.rule_engine.model.DiscountRules;
import com.onecode.rule_engine.model.PartnerTransaction;
import com.onecode.rule_engine.responses.RuleEngineResponse;

public abstract class CommissionProcessor {


	public abstract RuleEngineResponse CalculateCommission(DiscountRules rules,Optional<PartnerTransaction> partner_transaction);

	
}
