package com.demo.kafkademo.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class KafkaConsumer {

    private final String consumerId = UUID.randomUUID().toString();

    @KafkaListener(topics = "demo-topic", groupId = "demo-group")
    public void consume(String message) {
        System.out.println("Consumer [" + consumerId + "] received message: " + message);
    }
}