package com.onecode;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;



@ComponentScan("com.onecode.onecodeproject.RuleEngine")
@ComponentScan("com.onecode.onecodeproject.DiscountRulesClasses")
@ComponentScan("com.onecode.onecodeproject.responses")
@ComponentScan("com.onecode.onecodeproject.service")
@EntityScan(basePackages="com.onecode.onecodeproject.model")
@SpringBootApplication
public class OnecodeRuleEngineApplication {

	
	
	public static void main(String[] args) {
		SpringApplication.run(OnecodeRuleEngineApplication.class, args);
	}

}
