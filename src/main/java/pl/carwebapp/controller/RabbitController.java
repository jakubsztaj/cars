package pl.carwebapp.controller;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.carwebapp.message.Recv;
import pl.carwebapp.message.Send;
import pl.carwebapp.service.RentalService;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeoutException;


@RestController
@CrossOrigin
@RequestMapping("/message")
public class RabbitController {


    Send rabbitSender;

    Recv recv;

    RentalService rentalService;

    @Autowired
    public RabbitController(Send rabbitSender, Recv recv, RentalService rentalService) {
        this.rabbitSender = rabbitSender;
        this.recv = recv;
        this.rentalService = rentalService;
    }

    @GetMapping("/send")
    public String sendMessage() throws IOException, TimeoutException {
        rabbitSender.sendMessage();
        return "Message published";
    }

    @GetMapping("/receive")
    public String receiveMessage() throws IOException, TimeoutException {
        recv.receiveMessage();
        return "Message received";
    }

    @GetMapping("/receive/batch/{queueName}/{batchSize}")
    public List<String> receiveMessageBatch(@PathVariable String queueName, @PathVariable int batchSize) throws IOException, TimeoutException {
        return rentalService.receiveBatch(queueName, batchSize);
    }

//    @GetMapping("/receive/batch/{queueName}/{batchSize}")
//    public List<String> receiveMessageBatchTopic(@PathVariable String queueName, @PathVariable int batchSize) throws IOException, TimeoutException {
//        return rentalService.receiveBatchTopic(queueName, batchSize);
//    }
}
