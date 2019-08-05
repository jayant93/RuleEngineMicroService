package com.onecode.rule_engine.CheckClasses;

import java.util.Optional;
import com.onecode.rule_engine.RuleEngineInterface.CheckCaseInterface;
import com.onecode.rule_engine.model.PartnerTransaction;
import org.springframework.stereotype.Component;

@Component
public class DoesPartnerExist implements CheckCaseInterface {

	boolean status = false;
	
	@Override
	public boolean validate(Optional<PartnerTransaction> partner_transaction) {
		partner_transaction.ifPresent(transaction -> {
			if(transaction.getPartnerId()!=null) {
				status = true;
			}
		});
	return status;
	}

}
