package com.codewithmosh.store;

import com.codewithmosh.store.entities.Address;
import com.codewithmosh.store.entities.Tag;
import com.codewithmosh.store.entities.User;
import com.codewithmosh.store.services.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class StoreApplication {

    public static void main(String[] args) {
//        ApplicationContext context = SpringApplication.run(StoreApplication.class, args);

var user = User.builder()
                .name("John Doe")
                .email("john@codewithMosh.com")
                .password("password")
                .build();

user.addTag("Tag_one");


//var address = Address.builder()
//                .street("123 Main St")
//                .city("Springfield")
//                .zip("12345")
//                .state("IL")
//                .build();

        System.out.println(user);
    }
}
