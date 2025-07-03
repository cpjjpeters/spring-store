package com.codewithmosh.store.depinjection;

import org.junit.jupiter.api.Test;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.Arrays;
import java.util.List;

public class StripePaymentServiceUnitTest {

    @Test
    public void testStripePaymentServiceManually() {
        System.out.println("[DEBUG_LOG] Starting manual StripePaymentService test");
        
        // Create a new instance of StripePaymentService
        StripePaymentService service = new StripePaymentService();
        
        // Set the properties manually using reflection
        ReflectionTestUtils.setField(service, "apiUrl", "https://api.stripe.com");
        ReflectionTestUtils.setField(service, "enabled", false);
        ReflectionTestUtils.setField(service, "timeout", 4000);
        
        List<String> currencies = Arrays.asList("USD", "EUR", "GBP");
        ReflectionTestUtils.setField(service, "supportedCurrencies", currencies);
        
        // Call the processPayment method
        System.out.println("[DEBUG_LOG] Calling processPayment");
        service.processPayment(100.0);
        
        System.out.println("[DEBUG_LOG] Manual StripePaymentService test completed successfully");
    }
}