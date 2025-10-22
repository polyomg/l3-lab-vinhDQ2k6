package poly.edu.service;

import jakarta.mail.MessagingException;
import poly.edu.model.Mail;

public interface MailService {
    void send(Mail mail) throws MessagingException;

    void send(String to, String subject, String body) throws MessagingException;

    void push(Mail mail);

    default void push(String to, String subject, String body) {
        this.push(Mail.builder().to(to).subject(subject).body(body).build());
    }
}
