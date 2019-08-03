package com.onecode.onecodeproject.CheckClasses;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.onecode.onecodeproject.RuleEngineInterface.CheckCaseInterface;
import com.onecode.onecodeproject.model.DiscountRules;
import com.onecode.onecodeproject.model.PartnerTransaction;
import com.onecode.onecodeproject.repository.DiscountRulesRepository;

@Component
public class DoesDiscountRuleExist implements CheckCaseInterface{

	@Autowired
	DiscountRulesRepository rule_repo;
	
	boolean status = false;
	
	int Rules=0;
	
	@Override
	public boolean CheckForDiscountRule(Optional<PartnerTransaction> partner_transaction) {
		
		partner_transaction.ifPresent(transaction -> {
			if(transaction.getPartnerId()!=null) {
				Rules=rule_repo.findAllByIsActive(true,transaction.getPartnerId()).size();
					}
		});
		if(Rules>0) {
			status = true;
		}
		
		return status;
		
	}

	@Override
	public boolean checkForTransactionId(Optional<PartnerTransaction> partner_transaction) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean checkForPartnerId(Optional<PartnerTransaction> partner_transaction) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean CheckForDiscountRuleAmbiquity(List<DiscountRules> rules) {
		// TODO Auto-generated method stub
		return false;
	}
}
