package com.codewithmosh.store;

import com.codewithmosh.store.depinjection.OrderService;
import com.codewithmosh.store.depinjection.PayPalPaymentService;
import com.codewithmosh.store.entities.User;
import com.codewithmosh.store.services.NotificationManager;
import com.codewithmosh.store.services.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.math.BigDecimal;

@SpringBootApplication
public class StoreApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(StoreApplication.class, args);
        var manager = context.getBean( NotificationManager.class);
        manager.sendNotification("Hello", "John Doe");

//        var service =  context.getBean(UserService.class);
//        service.fetchPaginatedProducts(0, 10);
//        User.builder()
//                .name("John Doe")
//                .email("john.doe@example.com" )
//                .password("password")
//                .build();
//        var user = new User();
//        user.setName("John Doe");
//        user.setEmail("john.doe@example.com");
//        user.setPassword("password123");

        var orderService = new OrderService(new PayPalPaymentService());
        orderService.placeOrder();

    }
}
