package net.games.snack.service.mail;

import java.util.Map;
import java.util.Properties;

public class SecretProperties {
    public static final String USERNAME_KEY = "spring.mail.username";
    public static final String PASSWORD_KEY = "spring.mail.password";
    public static final String HOST_KEY = "spring.mail.host";
    public static final String PORT_KEY = "spring.mail.port";
    public static final String PROTOCOL_KEY = "mail.transport.protocol";
    public static final String AUTH_KEY = "mail.smtp.auth";
    public static final String START_TLS_KEY = "mail.smtp.starttls.enable";
    public static final String DEBUG_KEY = "mail.debug";
    public static final String EMAIL_ACCOUNT_KEY = "email.account.from";
    public static final String EMAIL_SUBJECT_KEY = "email.register.subject";

    private Properties properties = new Properties();

    public SecretProperties() {
        try {
            properties.load(ClassLoader.getSystemResourceAsStream("secret.properties"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Properties getProperties() {
        Properties result = new Properties(properties);
        for (Map.Entry<Object, Object> entry : properties.entrySet()) {
            result.put(entry.getKey(), entry.getValue());
        }
        return result;
    }
}
