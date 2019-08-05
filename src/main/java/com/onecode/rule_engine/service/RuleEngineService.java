package com.onecode.rule_engine.service;

import java.util.List;
import java.util.Optional;

import com.onecode.rule_engine.repository.TransactionRepository;
import com.onecode.rule_engine.responses.RuleEngineResponse;
import com.onecode.rule_engine.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onecode.rule_engine.CheckClasses.DiscountRulesAmbiquityCheck;
import com.onecode.rule_engine.CheckClasses.DoesDiscountRuleExist;
import com.onecode.rule_engine.CheckClasses.DoesPartnerExist;
import com.onecode.rule_engine.CheckClasses.IsTransactionIdPresent;
import com.onecode.rule_engine.DiscountRulesClasses.FixedDiscountRule;
import com.onecode.rule_engine.DiscountRulesClasses.PercentageBasedDiscountRule;
import com.onecode.rule_engine.RuleEngine.FetchDiscountRules;
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
	FixedDiscountRule fixedrule;

	@Autowired
	FetchDiscountRules FetchRules;
	
	@Autowired
	PercentageBasedDiscountRule percentageRule;

	Long transaction_partner_id;

	RuleEngineResponse response;

	// Variables for check status;
	boolean TransactionIdStatus = true;
	boolean PartnerIdStatus = true;
	boolean DiscountRulesStatus = true;

	// CheckCases Classes
	@Autowired
	IsTransactionIdPresent checkforTransactionId;

	@Autowired
	DoesPartnerExist checkforRelatedPartner;

	@Autowired
	DoesDiscountRuleExist checkforDiscountRules;
	
	@Autowired
	DiscountRulesAmbiquityCheck checkForDiscountRuleAmbiquity;
	
	
	@Autowired
	CalculatingDiscount calculateCommission;

	Boolean DiscountRulesFilterationStatus;
	
	public RuleEngineResponse StartCollectingTransactionInfo(Long transaction_id) {

		Double Zero = Double.valueOf(0);

		response = new RuleEngineResponse(Zero, Zero, "Incomplete", "No Transaction Id Present");
		/*
		 * here are three checks 1.is there any transaction present in db with this
		 * transaction Id 2.is there any partner id present related to that id 3.is
		 * there any discount rule present related to that partner id Lets Start the
		 * Selections
		 */
		partner_transaction = partner_transaction_repo.findById(transaction_id);

	
		/*
		 * Testing if transaction exists or not
		 */
		if(RuleEngineChecks.TransactionCheck) {
				TransactionIdStatus = checkforTransactionId.checkForTransactionId(partner_transaction);
				RuleEngineChecks.setDiscountRulesFilterationStatus(true);
		} 
			if(!TransactionIdStatus) {
						RuleEngineChecks.setPartnerIdCheck(false);
						RuleEngineChecks.setDiscountRuleCheck(false);
						RuleEngineChecks.setDiscountRulesFilterationStatus(false);
						RuleEngineChecks.setCalculateCommission(false);
			response = new RuleEngineResponse(Zero,Zero,"Incomplete","No Transaction Partner Id Present");
			}
		
					/*
					 * Testing if Partner associated with transaction exists or not
					 */
								
					if(RuleEngineChecks.PartnerIdCheck) {
							PartnerIdStatus = checkforRelatedPartner.checkForPartnerId(partner_transaction);
							RuleEngineChecks.setDiscountRulesFilterationStatus(true);
							}
					if(!PartnerIdStatus){
									
									RuleEngineChecks.setDiscountRuleCheck(false);
									RuleEngineChecks.setDiscountRulesFilterationStatus(false);
									RuleEngineChecks.setCalculateCommission(false);
								response = new RuleEngineResponse(Zero,Zero,"Incomplete","No Transaction Partner Id Present");
							}
								
							/*
							 * Testing if DiscountRule associated with transaction exists or not
							 */		
									if(RuleEngineChecks.DiscountRuleCheck) {
											DiscountRulesStatus = checkforDiscountRules.CheckForDiscountRule(partner_transaction);
											RuleEngineChecks.setDiscountRulesFilterationStatus(true);
											}
									 if(!DiscountRulesStatus){
													
													RuleEngineChecks.setDiscountRulesFilterationStatus(false);
													RuleEngineChecks.setCalculateCommission(false);
												response =new RuleEngineResponse(Zero,Zero,"Incomplete","No Discount Rules Present"); 
											}
				
									
									/*
									 * Fetching the discount Rules
									 */
												if(RuleEngineChecks.isDiscountRulesFilterationStatus()) {
													rules = FetchRules.getDiscountRule(partner_transaction);
												}
												
										/*
										 * Testing Rules List for Ambiquity		
										 */
//												if(RuleEngineChecks.isDiscountRulesFilterationStatus() &&
//														RuleEngineChecks.DiscountRuleAmbiquityCheck) {
//														if(!checkForDiscountRuleAmbiquity.CheckForDiscountRuleAmbiquity(rules))
//														{

			// FILTERING DISCOUNT RULES HERE _ NEEDS TO BE REMOVED

			filterDiscountRules();

			// FILTERING DISCOUNT RULES HERE _ NEEDS TO BE REMOVED
			RuleEngineChecks.setCalculateCommission(true);
//														}
//												}
																	
															/*
															 *CheckIfwehaveCalculateCommissionOrNot		
															 */
																	if(RuleEngineChecks.isCalculateCommission()) {
																		response = calculateCommission.CalculateCommission(rules.get(0),partner_transaction);
																		// create an entry for transaction in database here
																		partner_transaction.ifPresent(partnerTransaction -> {
																			Transaction transaction = new Transaction();
																			transaction.setAmount(response.getUser_Commission());
																			transaction.setPayOut(response.getUser_Commission() - response.getOneCode_Commission());
																			transaction.setPartnerId(partnerTransaction.getPartnerId());
																			transaction.setUserId(partnerTransaction.getUserId());
																			transaction.setPartnerTransactionId(partnerTransaction.getId());
																			transaction.setDicountRuleId(rules.get(0).getId());
																			transaction_repo.save(transaction);
																		});
																	}
																	
						/*
						 * FINAL STEp return commission with response											
						 */
		return response;

	}

	private void filterDiscountRules() {
		partner_transaction.ifPresent(partnerTransaction -> {
			// if there are more rules available to check
			if (rules.size() > 1) {

				DiscountRules currentRule = rules.get(0);

				if (currentRule.getFlat() != null && currentRule.getFlat()) {
					setValidRule();
					return;
				}

				// if the rule is based on new user or old user check
				if(currentRule.getIsNew() != null) {
					// whether the transaction has a value for NewUser
					// and if it matches that of the rule
					if(partnerTransaction.getIsNewUser() != null
							&& currentRule.getIsNew() == partnerTransaction.getIsNewUser()) {
						setValidRule();
						return;
					}
				}

				// if the rule is based on count
				if (currentRule.getCountBased() != null) {
					Long transactionCount = partner_transaction_repo.findNumberOfTransactions(partnerTransaction.getId(), partnerTransaction.getPartnerUserHash());
					if (transactionCount <= currentRule.getMaxTransactionCount()
						&& transactionCount >= currentRule.getMinTransactionCount()) {
						setValidRule();
						return;
					}
				}

				// if rule passes nothing remove it and make a recursive call
				rules.remove(0);
				filterDiscountRules();
			}
		});
	}

	// Removes all other rules if one qualifying rule is found
	private void setValidRule() {
		DiscountRules validRule = rules.get(0);
		rules.clear();
		rules.add(validRule);
	}
}
