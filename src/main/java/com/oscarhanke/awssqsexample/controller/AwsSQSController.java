package com.oscarhanke.awssqsexample.controller;

import com.oscarhanke.awssqsexample.AwsSqsExampleApplication;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener;
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

    Logger logger = LoggerFactory.getLogger(AwsSqsExampleApplication.class);

    @PostMapping
    public void sendMessageToQueue(@RequestBody String message){
        queueMessagingTemplate.send(endpoint, MessageBuilder.withPayload(message).build());
    }

//    @SqsListener("test-queue")
//    public void loadMessageFromSQS(String message){
//        logger.info("message from SQS Queue: {}", message);
//    }
}
