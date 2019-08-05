package com.onecode.rule_engine.CheckClasses;

import java.util.List;
import java.util.Optional;

import com.onecode.rule_engine.RuleEngineInterface.CheckCaseInterface;
import com.onecode.rule_engine.model.DiscountRules;
import com.onecode.rule_engine.model.PartnerTransaction;
import org.springframework.stereotype.Component;

@Component
public class IsTransactionIdPresent implements CheckCaseInterface {
		
	boolean status = false;
	
	@Override
	public boolean validate(Optional<PartnerTransaction> partner_transaction) {
			status = partner_transaction.isPresent();
		return status;
	}

	

}
