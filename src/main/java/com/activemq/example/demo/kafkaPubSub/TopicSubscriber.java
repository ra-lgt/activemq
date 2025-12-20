package com.activemq.example.demo.kafkaPubSub;

import javax.jms.*;
import org.apache.activemq.ActiveMQConnectionFactory;

public class TopicSubscriber {

    public static void main(String[] args) throws Exception {

        // 1. Connection Factory
        ConnectionFactory factory =
                new ActiveMQConnectionFactory("tcp://localhost:61616");

        // 2. Connection
        Connection connection = factory.createConnection();
        connection.setClientID("order-subscriber-1");
        connection.start();

        // 3. Session
        Session session =
                connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

        // 4. Topic
        Topic topic = session.createTopic("orders.topic");

        // 5. Subscriber
        MessageConsumer consumer =
                session.createConsumer(topic);

        System.out.println("Waiting for messages...");

        // 6. Listen
        consumer.setMessageListener(message -> {
            try {
                TextMessage textMessage = (TextMessage) message;
                System.out.println("Received: " + textMessage.getText());
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        // Keep app running
        Thread.sleep(100000);
    }
}
