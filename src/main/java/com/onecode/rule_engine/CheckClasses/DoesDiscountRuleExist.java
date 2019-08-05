package com.onecode.rule_engine.CheckClasses;


import java.util.Optional;
import com.onecode.rule_engine.RuleEngineInterface.CheckCaseInterface;
import com.onecode.rule_engine.model.PartnerTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.onecode.rule_engine.repository.DiscountRulesRepository;

@Component
public class DoesDiscountRuleExist implements CheckCaseInterface {

	@Autowired
	DiscountRulesRepository rule_repo;
	
	boolean status = false;
	
	int Rules=0;
	
	@Override
	public boolean validate(Optional<PartnerTransaction> partner_transaction) {
		
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
}
