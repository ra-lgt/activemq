package com.activemq.example.demo.kafkaPubSub;

import javax.jms.*;
import org.apache.activemq.ActiveMQConnectionFactory;

public class TopicPublisher {

    public static void main(String[] args) throws Exception {

        // 1. Connection Factory
        ConnectionFactory factory = new ActiveMQConnectionFactory("tcp://localhost:61616");

        // 2. Connection
        Connection connection = factory.createConnection();
        connection.start();

        // 3. Session
        Session session =connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

        // 4. Topic
        Topic topic = session.createTopic("orders.topic");

        // 5. Producer
        MessageProducer producer = session.createProducer(topic);
        producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);

        // 6. Message
        TextMessage message =session.createTextMessage("Order Placed: OrderID=101");

        // 7. Send
        producer.send(message);
        System.out.println("Message sent to topic");

        // 8. Cleanup
        session.close();
        connection.close();
    }
}
