package com.codewithmosh.store.depinjection;

/* carlpeters created on 26/06/2025 inside the package - com.codewithmosh.store.depinjection */
public class StripePaymentService implements PaymentService {
    @Override
    public void processPayment(double amount) {
        // Logic to process payment using Stripe API
        System.out.println("STRIPE" +
                " ");
        System.out.println("Processing payment of $" + amount + " using Stripe.");
    }
}
