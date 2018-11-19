package com.jauhaf.tdm.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * The type Send data.
 */
@Slf4j
@RestController
public class SendData {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    /**
     * Send data.
     *
     * @param data the data
     */
    @RequestMapping(value = "/sendData", method = RequestMethod.POST)
    public void sendData(@RequestParam("data") String data) {
        log.info("send data to consumer tdm [%s]", data);
        kafkaTemplate.send("topic-tdm", data);
    }
}
