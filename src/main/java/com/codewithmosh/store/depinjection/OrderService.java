package com.codewithmosh.store.depinjection;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    private PaymentService paymentService;

    public OrderService(@Qualifier("paypal") PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    public void placeOrder() {
//        var paymentService = new StripePaymentService();  niet meer nodig
        paymentService.processPayment(100.0);
    }
}
