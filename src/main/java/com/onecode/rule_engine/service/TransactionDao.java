package com.onecode.rule_engine.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.onecode.rule_engine.model.DiscountRules;
import com.onecode.rule_engine.model.PartnerTransaction;
import com.onecode.rule_engine.model.Transaction;
import com.onecode.rule_engine.repository.TransactionRepository;
import com.onecode.rule_engine.responses.RuleEngineResponse;

@Component
public class TransactionDao {

	@Autowired
	TransactionRepository transaction_repo;
	
	public void save(DiscountRules rule,RuleEngineResponse response, Optional<PartnerTransaction> partner_transaction) {
	
		//creating an entry in the db for transaction
		partner_transaction.ifPresent(partnerTransaction -> {
											Transaction transaction = new Transaction();
											transaction.setAmount(response.getUser_Commission());
											transaction.setPayOut(response.getUser_Commission() - response.getOneCode_Commission());
											transaction.setPartnerId(partnerTransaction.getPartnerId());
											transaction.setUserId(partnerTransaction.getUserId());
											transaction.setPartnerTransactionId(partnerTransaction.getId());
											transaction.setDicountRuleId(rule.getId());
											transaction_repo.save(transaction);
		});

		
	}

	
	
}
