package com.codewithmosh.store.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service("email")
@Primary
public class EmailNotificationService implements NotificationService {
    @Value("${mail.host")
    private String host;
    @Value("${mail.port}")
    private String port;
    @Override
    public void sendNotification(String message, String recipientEmail) {
        System.out.println("Sending email notification..." + " " + message +" " + recipientEmail);
        System.out.println("Using mail server: " + host + ":" + port);
    }
}
