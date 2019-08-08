package com.onecode.rule_engine.service;


import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.onecode.rule_engine.model.Transaction;
import com.onecode.rule_engine.repository.PartnerTransactionRepository;
import com.onecode.rule_engine.repository.UserRepository;
import com.onecode.rule_engine.model.DiscountRules;
import com.onecode.rule_engine.model.OnecodeUser;
import com.onecode.rule_engine.model.PartnerTransaction;
import com.onecode.rule_engine.responses.RuleEngineResponse;
import com.onecode.rule_engine.utils.createTransaction;


@Service
public class MultiLevelCommissionDistribution {

	ArrayList<Transaction> ListOfTransactions = new ArrayList<>();
	
	@Autowired
	createTransaction createTran;
	
	@Autowired
	PartnerTransactionRepository partner_transaction_repo;

	@Autowired
	OnecodeUser onecode;
	
	@Autowired
	UserRepository user_repo;
	
	@Autowired
	TransactionDao daoTransaction;
	
	public void MultiLevelCommissionCalculation(DiscountRules rule
				, RuleEngineResponse response, 
				PartnerTransaction transaction) {
			
				
			onecode = user_repo.findByIdAndAndIsVerified(transaction.getUserId(),true);
				if(onecode.getParent_id()!=null) {
				
					if(response.getUser_Commission() > 1 
							&& response.getOneCode_Commission() >1
						) {
						
					ListOfTransactions.add(
							createTran.creatingTransaction(
									rule,
									response,
									transaction));
					
								response.setUser_Commission(response.getUser_Commission()/10);	
					
								transaction.setUserId(onecode.getParent_id());
																				
								response.setOneCode_Commission(response.getOneCode_Commission()-response.getUser_Commission());
								
								MultiLevelCommissionCalculation(rule
										,response, 
										 transaction);
					}else {
						ListOfTransactions.add(
								createTran.creatingTransaction(
										rule,
										response,
										transaction));
							daoTransaction.saveTransactions(ListOfTransactions);
						return;
					}
				}
				else {
					ListOfTransactions.add(
							createTran.creatingTransaction(
									rule,
									response,
									transaction));
						daoTransaction.saveTransactions(ListOfTransactions);
					return;
				}
				
				
		}
	
}
