package com.codewithmosh.store.depinjection;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service("stripe")
@Primary
public class StripePaymentService implements PaymentService {
    @Override
    public void processPayment(double amount) {
        // Logic to process payment using Stripe API
        System.out.println("STRIPE" +
                " ");
        System.out.println("Processing payment of $" + amount + " using Stripe.");
    }
}
