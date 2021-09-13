package pl.carwebapp.service;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import pl.carwebapp.data.SupportRepository;

@Service
public class SupportService {
    private final SupportRepository supportRepository;

    public SupportService(SupportRepository supportRepository, JavaMailSender javaMailSender) {
        this.supportRepository = supportRepository;
        this.javaMailSender = javaMailSender;
    }

    public SupportRepository getSupportRepository() {
        return supportRepository;
    }

    private final JavaMailSender javaMailSender;

    public void sendSimpleMessage(String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo("aaarentalcompanybbb@gmail.com");
        message.setSubject(subject);
        message.setText(text);
        message.setFrom("aaarentalcompanybbb@gmail.com");
        javaMailSender.send(message);
    }
}
