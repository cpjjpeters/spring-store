package com.codewithmosh.store.depinjection;

/* carlpeters created on 26/06/2025 inside the package - com.codewithmosh.store.depinjection */
public class OrderService {
    private PaymentService paymentService;

    public OrderService(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    public void placeOrder() {
//        var paymentService = new StripePaymentService();  niet meer nodig
        paymentService.processPayment(100.0);
    }
}
