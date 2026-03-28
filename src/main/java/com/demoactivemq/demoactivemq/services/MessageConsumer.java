package com.demoactivemq.demoactivemq.services;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class MessageConsumer {

    @JmsListener(destination = "test.queue")
    public void receiveMessage(String message) {
        try {

            // ⏳ Simulate processing delay (10 seconds)
            Thread.sleep(10000);

            System.out.println("Processed: " + message);

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Processing interrupted");
        }
    }
}