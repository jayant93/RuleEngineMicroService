package com.onecode.onecodeproject.responses;

import org.springframework.stereotype.Component;

@Component
public class RuleEngineResponse {

	Double User_Commission;
	
	Double OneCode_Commission;
	
	String Transaction_Status;
	
	String Reason;
	
	public RuleEngineResponse(Double user_Commission, Double oneCode_Commission, String transaction_Status, String reason) {
		User_Commission = user_Commission;
		OneCode_Commission = oneCode_Commission;
		Transaction_Status = transaction_Status;
		Reason = reason;
	}

	public RuleEngineResponse() {
		// TODO Auto-generated constructor stub
	}

	public Double getUser_Commission() {
		return User_Commission;
	}

	public void setUser_Commission(Double user_Commission) {
		User_Commission = user_Commission;
	}

	public Double getOneCode_Commission() {
		return OneCode_Commission;
	}

	public void setOneCode_Commission(Double oneCode_Commission) {
		OneCode_Commission = oneCode_Commission;
	}

	public String getTransaction_Status() {
		return Transaction_Status;
	}

	public void setTransaction_Status(String transaction_Status) {
		Transaction_Status = transaction_Status;
	}

	public String getReason() {
		return Reason;
	}

	public void setReason(String reason) {
		Reason = reason;
	}
	
	@Override
	public String toString() {
		return "User commission = "+User_Commission+" \n"
				+ "OneCode commission = "+OneCode_Commission+" \n"
						+ "Transaction Status = "+Transaction_Status+" \n"
						+"Reason = "+Reason
				;
		
	}
}
