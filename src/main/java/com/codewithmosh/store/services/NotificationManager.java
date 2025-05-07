package com.codewithmosh.store.services;

import org.springframework.stereotype.Service;

/* carlpeters created on 07/05/2025 inside the package - com.codewithmosh.store.services */
@Service
public class NotificationManager {
    private final NotificationService notificationService;

    public NotificationManager(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    public void sendNotification(String message, String recipient) {
        notificationService.sendNotification(message, recipient);
    }
}
