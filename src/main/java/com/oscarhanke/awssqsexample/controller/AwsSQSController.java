package com.oscarhanke.awssqsexample.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("sqs")
@RequiredArgsConstructor
public class AwsSQSController {

    @Value("${cloud.aws.end-point.uri}")
    private String endpoint;

    private final QueueMessagingTemplate queueMessagingTemplate;

    @PostMapping
    public void sendMessageToQueue(@RequestBody String message){
        queueMessagingTemplate.send(endpoint, MessageBuilder.withPayload(message).build());
    }
}
