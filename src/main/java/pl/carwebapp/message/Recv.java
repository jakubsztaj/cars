package pl.carwebapp.message;

import com.rabbitmq.client.*;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

@Component
public class Recv {
    private final static String QUEUE_NAME = "helloworld";

    public String receiveMessage() throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setVirtualHost("/");
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        GetResponse response = channel.basicGet(QUEUE_NAME, false);
        Envelope envelope = response.getEnvelope();
        channel.basicAck(envelope.getDeliveryTag(), false);

        String message = new String(response.getBody(), "UTF-8");
        return "Received message: " + message;
    }
}
