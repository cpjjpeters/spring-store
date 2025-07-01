package com.codewithmosh.store.depinjection;

/* carlpeters created on 26/06/2025 inside the package - com.codewithmosh.store.depinjection */
public class PayPalPaymentService implements PaymentService {
    @Override
    public void processPayment(double amount) {
        // Logic to process payment using Stripe API
        System.out.println("PAYPAL" +
                " ");
        System.out.println("Processing payment of $" + amount + " using PayPal.");
    }
}
