package pl.carwebapp.service;

import com.google.common.collect.ImmutableMap;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import pl.carwebapp.model.Car;
import pl.carwebapp.model.Rental;

import javax.mail.internet.MimeMessage;

@Service
public class SupportService {

    public SupportService(JavaMailSender javaMailSender, FreeMarkerConfigurer freemarkerConfig) {
        this.javaMailSender = javaMailSender;
        this.freemarkerConfig = freemarkerConfig;
    }

    private final JavaMailSender javaMailSender;

    private final FreeMarkerConfigurer freemarkerConfig;

    public void sendSimpleMessage(String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo("aaarentalcompanybbb@gmail.com");
        message.setSubject(subject);
        message.setText(text);
        message.setFrom("aaarentalcompanybbb@gmail.com");
        javaMailSender.send(message);
    }

    public void sendRentalNotification(Rental rental) {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        try {
            String templateContent = FreeMarkerTemplateUtils
                    .processTemplateIntoString(freemarkerConfig.getConfiguration()
                                    .getTemplate("email.ftl"),
                            ImmutableMap.of("rental", rental));

            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);
            helper.setSubject("Rental created!");
            helper.setTo("aaarentalcompanybbb@gmail.com");
            helper.setText(templateContent, true);
            helper.setFrom("jakub.sztajerowski123@gmail.com");
            javaMailSender.send(mimeMessage);

        } catch (Exception e) {

        }
    }

    public void sendRentalReminder(Rental rental) {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        try {
            String templateContent = FreeMarkerTemplateUtils.
                    processTemplateIntoString(freemarkerConfig.getConfiguration()
                                    .getTemplate("reminder.ftl"),
                            ImmutableMap.of("rental", rental));

            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);
            helper.setSubject("Rental expiring!");
            helper.setTo("aaarentalcompanybbb@gmail.com");
            helper.setText(templateContent, true);
            helper.setFrom("aaarentalcompanybbb@gmail.com");
            javaMailSender.send(mimeMessage);

        } catch (Exception e) {

        }
    }

    public void sendCarNotification(Car car) {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        try {
            String templateContent = FreeMarkerTemplateUtils.
                    processTemplateIntoString(freemarkerConfig.getConfiguration()
                                    .getTemplate("notification.ftl"),
                            ImmutableMap.of("car", car));

            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);
            helper.setSubject("Car added!");
            helper.setTo("aaarentalcompanybbb@gmail.com");
            helper.setText(templateContent, true);
            helper.setFrom("aaarentalcompanybbb@gmail.com");
            javaMailSender.send(mimeMessage);

        } catch (Exception e) {

        }
    }
}
