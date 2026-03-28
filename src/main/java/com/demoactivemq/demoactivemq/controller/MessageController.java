package com.demoactivemq.demoactivemq.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.demoactivemq.demoactivemq.services.MessageProducer;

@RestController
@RequestMapping("/api")  // localhost:8080/api/
public class MessageController {

    @Autowired
    private  MessageProducer producer;


    @GetMapping("/send")   // localhost:8080/api/send?msg=Hello
    public String send(@RequestParam String msg) {
        producer.sendMessage(msg);
        return "Message Sent!";
    }
}