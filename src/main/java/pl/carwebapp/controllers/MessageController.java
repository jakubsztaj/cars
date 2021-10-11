package pl.carwebapp.controllers;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import pl.carwebapp.model.ChatMessage;

@Controller
public class MessageController {

    @MessageMapping("/chat")
    @SendTo("/topic/messages")
    public ChatMessage send(ChatMessage chatMessage) throws Exception {
        return new ChatMessage(chatMessage.getType(), chatMessage.getContent(), chatMessage.getSender(), chatMessage.getTime());
    }
}