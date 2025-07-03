package com.codewithmosh.store.depinjection;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class StripePaymentServiceTest {

    @Autowired
    private StripePaymentService stripePaymentService;

    @Test
    public void testStripePaymentService() {
        System.out.println("[DEBUG_LOG] Testing StripePaymentService");
        assertNotNull(stripePaymentService);
        stripePaymentService.processPayment(100.0);
        System.out.println("[DEBUG_LOG] StripePaymentService test completed");
    }
}