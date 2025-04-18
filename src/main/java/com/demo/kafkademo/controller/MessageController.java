package com.demo.kafkademo.controller;

import com.demo.kafkademo.producer.KafkaProducer;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/kafka/messages")
public class MessageController {

    private final KafkaProducer producerService;

    public MessageController(KafkaProducer producerService) {
        this.producerService = producerService;
    }

    @PostMapping(
            consumes = "application/json"
    )
    public String sendMessage(@RequestBody String message) {
        producerService.sendMessage(message);
        return "Message sent: " + message;
    }
}