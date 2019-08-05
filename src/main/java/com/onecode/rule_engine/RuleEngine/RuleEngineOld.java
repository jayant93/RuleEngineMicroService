package com.onecode.rule_engine.RuleEngine;

import java.util.ArrayList;

import com.onecode.rule_engine.model.DiscountRules;
import com.onecode.rule_engine.model.PartnerTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import com.onecode.rule_engine.repository.DiscountRulesRepository;
import com.onecode.rule_engine.repository.PartnerTransactionRepository;


public class RuleEngineOld {

    @Autowired
    DiscountRulesRepository rules_repo;
    
    @Autowired
    PartnerTransactionRepository partner_transaction_repo;
    
    ArrayList<DiscountRules> Rules;
    
    @Autowired
	PartnerTransaction partnerTransaction;
    
    Double TotalNumberOfTransactions =0.0;  
    
    //Default constructor initializing the instance variables
    public RuleEngineOld(){
        //Collecting data from repos for Data Processing of Rule Engine
    		
    			partnerTransaction = partner_transaction_repo.findOne(Long.valueOf(103));
    			//Rules = (ArrayList<DiscountRules>) rules_repo.findAllByIsActive(true,Long.valueOf(103));
    		//	TotalNumberOfTransactions = partner_transaction_repo.findNumberOfTransactions(Long.valueOf(103));
    			}
    
    //Rule Engine For Processing the Transaction Data
	public  void StartRuleEngine() {
		//Temporart variable for Data processing
		//Minimum transaction Amount 
		Double minimum_transaction_amount = 2000.00;
		
		//Type Of User
		Boolean typeOfUser = partnerTransaction.getIsNewUser();
		
		//Transaction Type
		Boolean TimeBased = true;
		Boolean Number_Of_TransactionsBased = false;
		
		//Temporary Variables
		Double TimeElapsed = 200.00; //in milliseconds
		
		//Commissions
		Double User_commission = 0.0;
		Double OneCode_commission = 0.0;
		
		
		//Lets Start comparing the features
			for(DiscountRules rule : Rules) {
				
				/*	
				  * 
				  * NEW USER CHECKS
				  * 
				  */
					 //Further Condition evaluation for new user
						if(typeOfUser == true) {
						
					
							 //minimum transaction amount check
							    if(partnerTransaction.getAmount() >= rule.getMinTransactionAmount()) {
							    	//if the discount is time based
							    		if(TimeBased) {
							    			//when commission is percentage based
							    			if(TimeElapsed > rule.getMinTimeElapsed()
							    					&& TimeElapsed < rule.getMaxTimeElapsed() 
							    					&& rule.getPartnerUserdiscountType() =="Percentage"
							    					&& rule.getCountBased() != true) {
							    				Double Temp = (partnerTransaction.getAmount() * rule.getPartnerDiscount()) /100;	
							    				User_commission = Temp - (Temp*10)/100;
							    				OneCode_commission = (Temp*10)/100;
							    				System.out.println("User commission = "+User_commission);
							    				System.out.println("OneCode commission = "+OneCode_commission);
							    			}
							    			//when commission is fixed							    			
							    			else if(TimeElapsed > rule.getMaxTimeElapsed() &&
							    					rule.getPartnerUserdiscountType() =="fixed"
							    					&& rule.getCountBased() != true) {
							    				//Fixed Earnings
							    				Double Temp = rule.getPartnerDiscount();
							    				User_commission = Temp;
							    				OneCode_commission = (Temp*10)/100;
							    				System.out.println("User commission = "+User_commission);
							    				System.out.println("OneCode commission = "+OneCode_commission);
							    			}
							    			//when commission is incremental
							    				else if(rule.getPartnerUserdiscountType() == "incremental" && rule.getCountBased() == true) {
							    				User_commission = TotalNumberOfTransactions * rule.getPartnerDiscount();
							    				OneCode_commission = (User_commission*10)/100;
							    				System.out.println("User commission = "+User_commission);
							    				System.out.println("OneCode commission = "+OneCode_commission);
							    			}
							    			
							    		}
							    		//if the discount is based in number of transactions
							    		else if(Number_Of_TransactionsBased) {
							    			//when commission is percentage based
							    			if(TotalNumberOfTransactions > rule.getMinTransactionCount() 
							    					&& TotalNumberOfTransactions > rule.getMaxTransactionCount()
							    					&& rule.getPartnerUserdiscountType() =="Percentage"
							    					&& rule.getCountBased() != true) {
							    				Double Temp = (partnerTransaction.getAmount() * rule.getPartnerDiscount()) /100;	
							    				User_commission = Temp - (Temp*10)/100;
							    				OneCode_commission = (Temp*10)/100;
							    				System.out.println("User commission = "+User_commission);
							    				System.out.println("OneCode commission = "+OneCode_commission);
							    			}
							    			//when commission is fixed
							    			else if(TotalNumberOfTransactions > rule.getMaxTransactionCount()
							    					&& rule.getPartnerUserdiscountType() =="fixed"
							    					&& rule.getCountBased() != true) {
							    				//Fixed Earnings
							    				Double Temp = rule.getPartnerDiscount();
							    				User_commission = Temp;
							    				OneCode_commission = (Temp*10)/100;
							    				System.out.println("User commission = "+User_commission);
							    				System.out.println("OneCode commission = "+OneCode_commission);
							    		}
							    			//when commission is incremental
							    			else if(rule.getPartnerUserdiscountType() == "incremental"
							    					&& rule.getCountBased() == true) {
							    				User_commission = TotalNumberOfTransactions * rule.getPartnerDiscount();
							    				OneCode_commission = (User_commission*10)/100;
							    				System.out.println("User commission = "+User_commission);
							    				System.out.println("OneCode commission = "+OneCode_commission);
							    			}
							    }
							 
							 
						 }
						 
						 
				
				/*
				  * 
				  * OLD USER CHECKS
				  * 
				  */
				/*
				 * if(typeOfUser != true) { //Now check for commission type
				 * if(rule.getPartnerUserdiscountType() == "fixed") {
				 * if(partnerTransaction.getAmount() >= minimum_transaction_amount) {
				 * 
				 * } }
				 * 
				 * if(rule.getPartnerUserdiscountType() != "fixed") { //minimum transaction
				 * amount check if(partnerTransaction.getAmount() >= minimum_transaction_amount)
				 * {
				 * 
				 * }
				 * 
				 * } }//closing of Old User if else
				 * 
				 */
				
	
			}
			
	}

	
	}
	}
