package com.onecode.rule_engine.service;

import java.util.List;
import java.util.Optional;

import com.onecode.rule_engine.repository.TransactionRepository;
import com.onecode.rule_engine.responses.RuleEngineResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.onecode.rule_engine.CheckClasses.DoesDiscountRuleExist;
import com.onecode.rule_engine.CheckClasses.DoesPartnerExist;
import com.onecode.rule_engine.CheckClasses.IsTransactionIdPresent;
import com.onecode.rule_engine.RuleEngine.FetchDiscountRules;
import com.onecode.rule_engine.RuleEngineInterface.CheckCaseInterface;
import com.onecode.rule_engine.model.DiscountRules;
import com.onecode.rule_engine.model.PartnerTransaction;
import com.onecode.rule_engine.repository.DiscountRulesRepository;
import com.onecode.rule_engine.repository.PartnerTransactionRepository;
import com.onecode.rule_engine.utils.RuleEngineChecks;

@Service
public class RuleEngineService {

	@Autowired
	PartnerTransactionRepository partner_transaction_repo;

	@Autowired
	TransactionRepository transaction_repo;

	@Autowired
	Optional<PartnerTransaction> partner_transaction;

	@Autowired
	DiscountRulesRepository rule_repo;

	@Autowired
	List<DiscountRules> rules;

	@Autowired
	TransactionDao saveTransaction;
		
	@Autowired
	FetchDiscountRules FetchRules;

	@Autowired
	MultiLevelCommissionDistribution multilevel;
	
	CheckCaseInterface check;
	
	Long transaction_partner_id;

	RuleEngineResponse response;

	// Variables for check status;
	boolean TransactionIdStatus = true;
	boolean PartnerIdStatus = true;
	boolean DiscountRulesStatus = true;

	
	@Autowired
	CalculatingDiscount calculateCommission;

	Boolean DiscountRulesFilterationStatus;
	
	public RuleEngineResponse StartProcessing(Long transaction_id) {
		


		Double Zero = Double.valueOf(0);

		response = new RuleEngineResponse(Zero, Zero, "Incomplete", "No Transaction Id Present");
		/*
		 * here are three checks 1.is there any transaction present in db with this
		 * transaction Id 2.is there any partner id present related to that id 3.is
		 * there any discount rule present related to that partner id Lets Start the
		 * Selections
		 */
	
		try {
			partner_transaction = partner_transaction_repo.findById(transaction_id);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	
		/*
		 * Testing if transaction exists or not
		 */
		try {
			if(RuleEngineChecks.TransactionCheck) {
					check = new IsTransactionIdPresent();
					TransactionIdStatus = check.validate(partner_transaction);
					RuleEngineChecks.setDiscountRulesFilterationStatus(true);
			} 
				if(!TransactionIdStatus) {
							RuleEngineChecks.setPartnerIdCheck(false);
							RuleEngineChecks.setDiscountRuleCheck(false);
							RuleEngineChecks.setDiscountRulesFilterationStatus(false);
							RuleEngineChecks.setCalculateCommission(false);
				response = new RuleEngineResponse(Zero,Zero,"Incomplete","No Transaction Partner Id Present");
				}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
					/*
					 * Testing if Partner associated with transaction exists or not
					 */
								
					try {
						if(RuleEngineChecks.PartnerIdCheck) {
							check = new DoesPartnerExist();
								PartnerIdStatus = check.validate(partner_transaction);
								RuleEngineChecks.setDiscountRulesFilterationStatus(true);
								}
						if(!PartnerIdStatus){
										
										RuleEngineChecks.setDiscountRuleCheck(false);
										RuleEngineChecks.setDiscountRulesFilterationStatus(false);
										RuleEngineChecks.setCalculateCommission(false);
									response = new RuleEngineResponse(Zero,Zero,"Incomplete","No Transaction Partner Id Present");
								}
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
								
							/*
							 * Testing if DiscountRule associated with transaction exists or not
							 */		
									try {
										if(RuleEngineChecks.DiscountRuleCheck) {
											check =new DoesDiscountRuleExist();
												DiscountRulesStatus = check.validate(partner_transaction);
												RuleEngineChecks.setDiscountRulesFilterationStatus(true);
												}
										 if(!DiscountRulesStatus){
														
														RuleEngineChecks.setDiscountRulesFilterationStatus(false);
														RuleEngineChecks.setCalculateCommission(false);
													response =new RuleEngineResponse(Zero,Zero,"Incomplete","No Discount Rules Present"); 
												}
									} catch (Exception e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
				
									
									/*
									 * Fetching the discount Rules
									 */
												try {
													if(RuleEngineChecks.isDiscountRulesFilterationStatus()) {
														rules = FetchRules.getDiscountRule(partner_transaction);
														if(rules.size()>0)
														RuleEngineChecks.setCalculateCommission(true);
													}
												} catch (Exception e) {
													// TODO Auto-generated catch block
													e.printStackTrace();
												}
								
		
															/*
															 *CheckIfwehaveCalculateCommissionOrNot		
															 */
																	try {
																		if(RuleEngineChecks.isCalculateCommission()) {
																			response = calculateCommission.CalculateCommission(rules.get(0),partner_transaction);
																			//Calculating multi level commission
																			
																			partner_transaction.ifPresent(transaction ->{
																				multilevel.MultiLevelCommissionCalculation(rules.get(0),response,transaction);	
																			});
																			
																			// create an entry for transaction in database here
																			
																			//saveTransaction.save(rules.get(0),response,partner_transaction);
																					}
																	} catch (Exception e) {
																		// TODO Auto-generated catch block
																		e.printStackTrace();
																	}
																	
						/*
						 * FINAL STEp return commission with response											
						 */
		return response;

	}




	
	
	
}
