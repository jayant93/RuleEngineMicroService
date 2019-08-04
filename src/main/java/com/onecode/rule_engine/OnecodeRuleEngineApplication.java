package com.onecode.rule_engine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;



@ComponentScan("com.onecode.rule_engine.RuleEngine")
@ComponentScan("com.onecode.rule_engine.DiscountRulesClasses")
@ComponentScan("com.onecode.rule_engine.responses")
@ComponentScan("com.onecode.rule_engine.service")
@EntityScan(basePackages="com.onecode.rule_engine.model")
@SpringBootApplication
public class OnecodeRuleEngineApplication {

	
	
	public static void main(String[] args) {
		SpringApplication.run(OnecodeRuleEngineApplication.class, args);
	}

}
