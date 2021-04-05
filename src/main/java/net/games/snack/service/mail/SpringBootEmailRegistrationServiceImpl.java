package net.games.snack.service.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class SpringBootEmailRegistrationServiceImpl implements EmailRegistrationService {
    @Autowired
    private JavaMailSender mailSender;

    public SpringBootEmailRegistrationServiceImpl(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    @Override
    public void sendRegistrationEmail(String address) {
        try {
            SecretProperties secret = new SecretProperties();
            Properties props = secret.getProperties();

            MimeMessage msg = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(msg, false);
            helper.setTo(address);
            helper.setSubject("Test message from SpringBoot");
            helper.setText("<p><b>Bold</b> test message.</p>");
            mailSender.send(msg);
        } catch (Exception e) {
            System.err.println(e.getMessage());
            e.printStackTrace(System.err);
        }
    }
}
