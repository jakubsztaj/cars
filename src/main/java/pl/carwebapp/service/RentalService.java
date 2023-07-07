package pl.carwebapp.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.rabbitmq.client.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import pl.carwebapp.data.CarRepository;
import pl.carwebapp.data.RentalRepository;
import pl.carwebapp.data.UserRepository;
import pl.carwebapp.model.*;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeoutException;

import static pl.carwebapp.model.PaymentStatus.DEFICIENCY;
import static pl.carwebapp.model.RentalStatus.ACTIVE;

@Service
public class RentalService {
    private final CarRepository carRepository;

    private final UserRepository userRepository;

    private final RentalRepository rentalRepository;

    @Transactional
    public void createRental(String pesel, String vin, LocalDateTime rentalBegin, LocalDateTime rentalEnd, BigDecimal deposit, Location location) throws Exception {
        Car car = carRepository.findByVin(vin).get();
        User user = userRepository.findByPesel(pesel).get();

        var rental = new Rental();
        rental.setRenter(user);
        rental.setCar(car);
        rental.setRentalBegin(rentalBegin);
        rental.setRentalEnd(rentalEnd);
        rental.setDeposit(deposit);
        rental.setLocation(location);
        rental.setRentalStatus(ACTIVE);
        rental.setPaymentStatus(DEFICIENCY);


        try {
            String routingKey = getRoutingKeyBasedOnCarType(car.getType());

            rentalRepository.save(rental);

            sendRentalInformationMessage(rental, routingKey);
        } catch (IllegalArgumentException exception) {
            sendRentalInformationMessage(rental, "deadletter");
        }


        // receiveRentalData();
    }

    public void sendRentalInformationMessage(Rental rental, String routingKey) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setVirtualHost("/");
        factory.setHost("localhost");

        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {

            ObjectMapper mapper = new ObjectMapper();
            mapper.registerModule(new JavaTimeModule());
            mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false); // Disable timestamp serialization

            String rentalJson = mapper.writeValueAsString(rental);

            AMQP.BasicProperties properties = new AMQP.BasicProperties.Builder()
                    .expiration("100000")
                    .build();

            channel.basicPublish("rental.exchange.topic", routingKey, properties, rentalJson.getBytes());
        }
    }

    private String getRoutingKeyBasedOnCarType(String carType) {
        return switch (carType) {
            case "SEDAN" -> "three.SEDAN";
            case "HATCHBACK" -> "HATCHBACK";
            case "VAN" -> "one.VAN";
            case "TRACK" -> "TRACK";
            case "SUV" -> "SUV";
            case "PRESTIGE" -> "PRESTIGE";
            default -> throw new IllegalArgumentException("Unknown car type: " + carType);
        };
    }

    public List<String> receiveBatch(String queueName, int batchSize) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setVirtualHost("/");
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.basicQos(batchSize, false);

        List<String> messages = new ArrayList<>();

        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            String message = new String(delivery.getBody(), StandardCharsets.UTF_8);
            messages.add(message);
            channel.basicAck(delivery.getEnvelope().getDeliveryTag(), false);

            if (messages.size() >= batchSize) {
                channel.basicCancel(consumerTag);
            }
        };

        channel.basicConsume(queueName, false, deliverCallback, consumerTag -> {
        });

        while (messages.size() < batchSize) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        return messages;
    }

    public String receiveRentalData() throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setVirtualHost("/");
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        GetResponse response = channel.basicGet("rental", false);
        Envelope envelope = response.getEnvelope();
        channel.basicAck(envelope.getDeliveryTag(), false);

        String message = new String(response.getBody(), "UTF-8");
        return "Received message: " + message;
    }


    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public List<Rental> getAllRentals() {
        return rentalRepository.findAll();
    }

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public List<Rental> getActiveRentals() {
        return rentalRepository.findAllByRentalStatus(ACTIVE);
    }

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public List<Rental> getClearRentals() {
        return rentalRepository.findAllByPaymentStatus(DEFICIENCY);
    }


    public RentalService(CarRepository carRepository, UserRepository userRepository, RentalRepository rentalRepository) {
        this.carRepository = carRepository;
        this.userRepository = userRepository;
        this.rentalRepository = rentalRepository;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void deleteRental() {
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void deleteRentals() {
        rentalRepository.deleteAll();
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void changeStatus(String vin) {
        rentalRepository.findByCarVin(vin).ifPresent(rental -> {
            rental.markPaymentCompleted();
            rentalRepository.save(rental);
        });

    }

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public List<Rental> filterByStatus(PaymentStatus paymentStatus) {
        return rentalRepository.findAllByPaymentStatus(paymentStatus);
    }

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public int countRentals() {
        return (int) rentalRepository.count();
    }
}
