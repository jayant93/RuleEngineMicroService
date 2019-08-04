package com.onecode.rule_engine.RuleEngine;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.onecode.rule_engine.responses.RuleEngineResponse;
import com.onecode.rule_engine.service.RuleEngineService;
import com.onecode.rule_engine.utils.RuleEngineChecks;

@RestController
@RequestMapping("/RuleEngine")
public class RuleEngineProcessing {

	@Autowired
	RuleEngineService rule;
	
	@Autowired(required = true)
	RuleEngineChecks checks;
	
	@Autowired
	RuleEngineResponse response;
	
	@GetMapping("/Start")
		public RuleEngineResponse startRuleEngine(@RequestParam("id") Long transaction_id) {
			
					
			//setting the checkcases to be performed
			checks.setChecks();
			response = rule.StartCollectingTransactionInfo(transaction_id);
			System.out.println(response.toString());
			return response;
		}
	
}
