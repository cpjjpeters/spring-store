package com.codewithmosh.store.services;

/* carlpeters created on 07/05/2025 inside the package - com.codewithmosh.store.services */

public class SMSNotificationService implements NotificationService {
    @Override
    public void sendNotification(String message, String recipient) {
        System.out.println("Sending SMS notification... " + " " + message +" " + recipient);
    }
}
