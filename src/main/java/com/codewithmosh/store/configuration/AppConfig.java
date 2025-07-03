package com.codewithmosh.store.configuration;

import com.codewithmosh.store.depinjection.OrderService;
import com.codewithmosh.store.depinjection.PayPalPaymentService;
import com.codewithmosh.store.depinjection.PaymentService;
import com.codewithmosh.store.depinjection.StripePaymentService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/* carlpeters created on 03/07/2025 inside the package - com.codewithmosh.store.configuratio

do not forget @Configuration or iit will not work !!! */

@Configuration
public class AppConfig {
    @Value("${payment-gateway:paypal}") // Default to 'stripe' if not specified
    private String paymentGateway;
    @Bean
    public PaymentService stripe() {
        return new StripePaymentService();
    }
    @Bean
    public PaymentService paypal() {
        return new PayPalPaymentService();
    }
    @Bean
    public OrderService orderService( ) {
        if(paymentGateway.equals("paypal")){
            return new OrderService(paypal());
        }
        return new OrderService(stripe());
    }
}
