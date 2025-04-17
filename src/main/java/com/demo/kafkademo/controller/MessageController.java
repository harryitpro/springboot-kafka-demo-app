package com.demo.kafkademo.controller;

import com.demo.kafkademo.service.KafkaProducerService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/kafka/messages")
public class MessageController {

    private final KafkaProducerService producerService;

    public MessageController(KafkaProducerService producerService) {
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