package com.kakfa.firstappliction.Consumer;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
@Service
public class KafkaConsumerService {
	 @KafkaListener(topics = "${app.kafka.topic}", groupId = "${spring.kafka.consumer.group-id}")
	    public void consume(String message) {
	        System.out.println("Consumed message: " + message);
	    }
}
