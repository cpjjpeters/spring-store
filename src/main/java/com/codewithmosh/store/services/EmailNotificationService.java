package com.codewithmosh.store.services;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

/* carlpeters created on 07/05/2025 inside the package - com.codewithmosh.store.services */
@Service("email")
@Primary
public class EmailNotificationService implements NotificationService {
    @Override
    public void sendNotification(String message, String recipient) {
        System.out.println("Sending email notification..." + " " + message +" " + recipient);
    }
}
