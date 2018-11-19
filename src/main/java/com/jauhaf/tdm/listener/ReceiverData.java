package com.jauhaf.tdm.listener;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

/**
 * The type Receiver data.
 */
@Service
public class ReceiverData {

    /**
     * Consume.
     *
     * @param message the message
     */
    @KafkaListener(topics = "topic-tdm",
            groupId = "group-tdm",
            containerFactory = "kafkaListenerContainerFactory")
    public void consume(@Payload String message) {
        System.out.println("consumed message => " + message);
    }
}
