package com.kakfa.firstappliction.producer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
@Service
public class KafkaProducerService {
	 private final KafkaTemplate<String, String> kafkaTemplate;

	    @Value("${app.kafka.topic}")
	    private String topicName;

	    public KafkaProducerService(KafkaTemplate<String, String> kafkaTemplate) {
	        this.kafkaTemplate = kafkaTemplate;
	    }

	    public void sendMessage(String message) {
	        kafkaTemplate.send(topicName, message);
	        System.out.println("Produced message: " + message);
	    }
}
