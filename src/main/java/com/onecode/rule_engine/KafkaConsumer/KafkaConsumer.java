package com.onecode.rule_engine.KafkaConsumer;

import java.util.concurrent.CountDownLatch;

import com.onecode.rule_engine.RuleEngine.RuleEngine;
import com.onecode.rule_engine.model.PartnerTransaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;

public class KafkaConsumer {
    private static final Logger LOGGER =
            LoggerFactory.getLogger(KafkaConsumer.class);

    private CountDownLatch latch = new  CountDownLatch(1);

    public CountDownLatch getLatch() {
        return latch;
    }

    @Autowired
    RuleEngine engine;

    @KafkaListener(topics = "transaction",groupId = "transactionQueue")
    public void receive(PartnerTransaction payload) {
        engine.start(payload.getId());
        latch.countDown();
    }
}
