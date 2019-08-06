package com.onecode.rule_engine.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.onecode.rule_engine.model.DiscountRules;
import com.onecode.rule_engine.model.PartnerTransaction;
import com.onecode.rule_engine.model.Transaction;
import com.onecode.rule_engine.repository.TransactionRepository;
import com.onecode.rule_engine.responses.RuleEngineResponse;
import com.onecode.rule_engine.Exceptions.NegativeValueException;


@Component
public class TransactionDao {

	@Autowired
	TransactionRepository transaction_repo;
	
	public void save(DiscountRules rule,RuleEngineResponse response, Optional<PartnerTransaction> partner_transaction) {
	
		//creating an entry in the db for transaction
		partner_transaction.ifPresent(partnerTransaction -> {
											Transaction transaction = new Transaction();
											try {
											transaction.setAmount(response.getUser_Commission());
											if(response.getUser_Commission() - response.getOneCode_Commission() <= 0) {
												throw new NegativeValueException("Commission can't be less than Zero");
											}
											transaction.setPayOut(response.getUser_Commission() - response.getOneCode_Commission());
											transaction.setPartnerId(partnerTransaction.getPartnerId());
											transaction.setUserId(partnerTransaction.getUserId());
											transaction.setPartnerTransactionId(partnerTransaction.getId());
											transaction.setDicountRuleId(rule.getId());
											}
											catch(IllegalArgumentException ae)
											{
														ae.printStackTrace();
														return;
												
											}	
											catch(NegativeValueException ne) {
												System.err.println(ne);
												return;
											}
											catch(NullPointerException ae) {
														ae.printStackTrace();
														return;
											}
											
											transaction_repo.save(transaction);
		});

		
	}

	
	
}
