package com.codewithmosh.store.depinjection;

import org.springframework.stereotype.Component;

/* carlpeters created on 26/06/2025 inside the package - com.codewithmosh.store.depinjection */
//@Component("paypal")
public class PayPalPaymentService implements PaymentService {
    @Override
    public void processPayment(double amount) {
        // Logic to process payment using Stripe API
        System.out.println("PAYPAL" +
                " ");
        System.out.println("Processing payment of $" + amount + " using PayPal.");
    }
}
