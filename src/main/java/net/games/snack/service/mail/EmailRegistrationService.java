package net.games.snack.service.mail;

import org.springframework.stereotype.Component;

@Component
public interface EmailRegistrationService {
    void sendRegistrationEmail(String address);
}
