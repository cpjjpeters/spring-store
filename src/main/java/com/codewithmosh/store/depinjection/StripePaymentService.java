package com.codewithmosh.store.depinjection;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service("stripe")
@Primary
public class StripePaymentService implements PaymentService {

    @Value("${stripe.apiUrl}")
    private String apiUrl;

    @Value("${stripe.enabled}")
    private boolean enabled;

    @Value("${stripe.timeout:3000}") // Default timeout of 3000ms if not specified
    private int timeout;

    @Value("#{'${stripe.supported-currencies:USD,EUR}'.split(',')}")
    private List<String> supportedCurrencies;

    @Override
    public void processPayment(double amount) {
        // Logic to process payment using Stripe API
        System.out.println("STRIPE" +
                " ");
        System.out.println("Processing payment of $" + amount + " using Stripe.");
        System.out.println("API URL: " + apiUrl);
        System.out.println("Enabled: " + enabled);
        System.out.println("Timeout: " + timeout + "ms");
        System.out.println("Supported Currencies: " + supportedCurrencies);
    }
}
