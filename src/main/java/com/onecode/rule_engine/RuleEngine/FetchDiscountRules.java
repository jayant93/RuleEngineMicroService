package com.onecode.rule_engine.RuleEngine;

import java.util.List;
import java.util.Optional;

import com.onecode.rule_engine.CheckClasses.CountBasedRule;
import com.onecode.rule_engine.CheckClasses.FlatRule;
import com.onecode.rule_engine.CheckClasses.NewUserRule;
import com.onecode.rule_engine.RuleEngineInterface.DiscountRuleProcessor;
import com.onecode.rule_engine.model.DiscountRules;
import com.onecode.rule_engine.model.PartnerTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.onecode.rule_engine.repository.DiscountRulesRepository;
import com.onecode.rule_engine.repository.PartnerTransactionRepository;

@Component
public class FetchDiscountRules {

	@Autowired
	DiscountRules rule;
	
	@Autowired
	List<DiscountRules> rules;
	
	@Autowired
	DiscountRulesRepository rule_repo;
	
	DiscountRuleProcessor Rulecheck;
	
	
	@Autowired
	PartnerTransactionRepository partner_transaction_repo;

//	Long Number_of_transactions;
	
	public List<DiscountRules> getDiscountRule(Optional<PartnerTransaction> partner_transaction) {
		
		try {
			partner_transaction.ifPresent(transaction -> {

					rules = rule_repo.findRule(true,transaction.getPartnerId());
					 filterDiscountRules(partner_transaction);

});
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return rules;
	}
	
	Integer val = 0;

	public void filterDiscountRules(Optional<PartnerTransaction> partner_transaction) {
		partner_transaction.ifPresent(partnerTransaction -> {
			
				DiscountRules currentRule = rules.get(val);

				
				try {
					Rulecheck = new FlatRule();
					if (Rulecheck.isValid(currentRule)) {
						setValidRule();
						return;
					}
				} catch (Exception e) {
										e.printStackTrace();
				}

				try {
					if(currentRule.getIsNew() != null) {
						Rulecheck = new NewUserRule();
					
						if(Rulecheck.isValid(currentRule,partnerTransaction)){
							setValidRule();
							return;
						}
					}
				} catch (Exception e) {
					
					e.printStackTrace();
				}

			
				try {
					if (currentRule.getCountBased() != null) {
						Rulecheck =new CountBasedRule();
								if (Rulecheck.isValid(currentRule, partnerTransaction)) {
											setValidRule();
											return;
						}
					}
				} catch (Exception e) {
					
					e.printStackTrace();
				}
				
		
				rules.remove(0);
				val++;
				filterDiscountRules(partner_transaction);
			
		});
	}
	
	// Removes all other rules if one qualifying rule is found
		private void setValidRule() {
			try {
				DiscountRules validRule = rules.get(val);
				rules.clear();
				rules.add(validRule);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	
}
