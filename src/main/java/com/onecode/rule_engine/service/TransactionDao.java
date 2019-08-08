package com.onecode.rule_engine.service;

import java.util.ArrayList;
import java.util.List;
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

	
	public void saveTransactions(ArrayList<Transaction> ListOfTransaction) {
		//Iterations for saving all the transactions
		for(int i=0;i< ListOfTransaction.size();i++) {
				transaction_repo.save(ListOfTransaction.get(i));
		}
	}
	
}
