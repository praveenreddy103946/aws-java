package com.prawin.notification_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kafka")
public class KafkaController {

    @Autowired
    private KafkaProducer producerService;

    @PostMapping("/publish")
    public ResponseEntity<String> send(@RequestParam String message) {
        producerService.sendMessage("aws-java", message);
        return ResponseEntity.ok("Message sent to Kafka");
    }
}

