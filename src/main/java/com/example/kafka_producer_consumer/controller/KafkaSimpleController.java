package com.example.kafka_producer_consumer.controller;

import com.example.kafka_producer_consumer.model.SimpleModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Controller;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/kafka")
public class KafkaSimpleController {


    private KafkaTemplate<String, SimpleModel> kafkaTemplate;

    @Autowired
    public KafkaSimpleController(KafkaTemplate<String, SimpleModel> kafkaTemplate) {
        this.kafkaTemplate= kafkaTemplate;
    }

    @PostMapping
    public void post(@RequestBody SimpleModel simpleModel) {
        kafkaTemplate.send("myTopic", simpleModel);
    }

    @KafkaListener(topics = "myTopic")
    public void getFromKafka(SimpleModel simpleModel) {
        System.out.println(simpleModel.toString());
    }
}
