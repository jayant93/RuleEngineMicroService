package com.onecode.rule_engine.utils;


import org.springframework.stereotype.Component;

@Component
public class RuleEngineChecks {

	public static boolean TransactionCheck;
	
	public static boolean PartnerIdCheck;
	
	public static boolean DiscountRuleCheck;
	
	public static boolean DiscountRuleAmbiquityCheck;
	
	public static boolean DiscountRulesFilterationStatus;
	
	public static boolean CalculateCommission;
	
	
	public void setChecks() {
	
		TransactionCheck = true;
		PartnerIdCheck = true;
		DiscountRuleCheck = true;
		DiscountRuleAmbiquityCheck = true;
		
	}

	public static boolean isPartnerIdCheck() {
		return PartnerIdCheck;
	}

	public static void setPartnerIdCheck(boolean partnerIdCheck) {
		PartnerIdCheck = partnerIdCheck;
	}

	public static boolean isDiscountRuleCheck() {
		return DiscountRuleCheck;
	}

	public static void setDiscountRuleCheck(boolean discountRuleCheck) {
		DiscountRuleCheck = discountRuleCheck;
	}

	public static boolean isDiscountRuleAmbiquityCheck() {
		return DiscountRuleAmbiquityCheck;
	}

	public static void setDiscountRuleAmbiquityCheck(boolean discountRuleAmbiquityCheck) {
		DiscountRuleAmbiquityCheck = discountRuleAmbiquityCheck;
	}

	public static boolean isDiscountRulesFilterationStatus() {
		return DiscountRulesFilterationStatus;
	}

	public static void setDiscountRulesFilterationStatus(boolean discountRulesFilterationStatus) {
		DiscountRulesFilterationStatus = discountRulesFilterationStatus;
	}
	
	public static boolean isCalculateCommission() {
		return CalculateCommission;
	}

	public static void setCalculateCommission(boolean calculateCommission) {
		CalculateCommission = calculateCommission;
	}

	
}
