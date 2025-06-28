package com.kakfa.firstappliction.Controller;

import org.springframework.web.bind.annotation.*;

import com.kakfa.firstappliction.producer.KafkaProducerService;

@RestController
@RequestMapping("/api/messages")
public class MessageController {

    private final KafkaProducerService producerService;

    public MessageController(KafkaProducerService producerService) {
        this.producerService = producerService;
    }

    @PostMapping
    public String sendMessage(@RequestBody String message) {
        producerService.sendMessage(message);
        return "Message sent to Kafka topic!";
    }
}
