package com.onecode.rule_engine.RuleEngine;

import com.onecode.rule_engine.service.RuleEngineService;
import com.onecode.rule_engine.utils.RuleEngineChecks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Component
public class RuleEngineProcessing {

	@Autowired
	RuleEngineService rule;
	
	@Autowired(required = true)
	RuleEngineChecks checks;

	public void startRuleEngine(Long transaction_id) {
		checks.setChecks();
		rule.StartCollectingTransactionInfo(transaction_id);
	}
	
}
