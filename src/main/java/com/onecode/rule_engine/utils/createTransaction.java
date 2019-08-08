package com.onecode.rule_engine.utils;


import org.springframework.stereotype.Component;
import com.onecode.rule_engine.model.DiscountRules;
import com.onecode.rule_engine.model.PartnerTransaction;
import com.onecode.rule_engine.model.Transaction;
import com.onecode.rule_engine.responses.RuleEngineResponse;

@Component
public class createTransaction {

 
	
	public Transaction creatingTransaction(DiscountRules rule,RuleEngineResponse response,PartnerTransaction partnerTransaction) {
		
			Transaction transaction = new Transaction();
			
			transaction.setAmount(response.getOneCode_Commission());
			transaction.setPayOut(response.getUser_Commission());
			transaction.setPartnerId(partnerTransaction.getPartnerId());
			transaction.setUserId(partnerTransaction.getUserId());
			transaction.setPartnerTransactionId(partnerTransaction.getId());
			transaction.setDicountRuleId(rule.getId());
			

		return transaction;

	}
	
}
