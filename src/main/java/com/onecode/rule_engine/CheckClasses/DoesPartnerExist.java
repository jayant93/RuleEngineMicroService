package com.onecode.rule_engine.CheckClasses;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.onecode.rule_engine.RuleEngineInterface.CheckCaseInterface;
import com.onecode.rule_engine.model.DiscountRules;
import com.onecode.rule_engine.model.PartnerTransaction;

@Component
public class DoesPartnerExist implements CheckCaseInterface{

	boolean status = false;
	
	@Override
	public boolean checkForPartnerId(Optional<PartnerTransaction> partner_transaction) {
		partner_transaction.ifPresent(transaction -> {
			if(transaction.getPartnerId()!=null) {
				status = true;
			}
		});
	return status;
	}

	@Override
	public boolean checkForTransactionId(Optional<PartnerTransaction> partner_transaction) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean CheckForDiscountRule(Optional<PartnerTransaction> partner_transaction) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean CheckForDiscountRuleAmbiquity(List<DiscountRules> rules) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
