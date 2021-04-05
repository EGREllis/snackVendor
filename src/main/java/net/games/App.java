package net.games;

import net.games.snack.service.mail.EmailRegistrationService;
import net.games.snack.service.mail.SpringBootEmailRegistrationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.javamail.JavaMailSender;

@SpringBootApplication
public class App 
{
    @Autowired
    private JavaMailSender sender;

    public static void main( String[] args ) {
        SpringApplication.run(net.games.App.class, args);
    }

     @Bean
    public EmailRegistrationService newEmailRegistrationService() {
        return new SpringBootEmailRegistrationServiceImpl(sender);
     }
}
