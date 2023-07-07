package pl.carwebapp.message;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.concurrent.TimeoutException;


@Component
public class Send {

    private final static String QUEUE_NAME = "helloworld";
    private final static String EXCHANGE_NAME = "helloworld.exchange";

    public void sendMessage() throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setVirtualHost("/");
        factory.setHost("localhost");

        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {

            String message = "Hello World!";
            channel.basicPublish(EXCHANGE_NAME, "hello", null, message.getBytes());
            System.out.println(" Sent '" + message + "'");
        }
    }
}
