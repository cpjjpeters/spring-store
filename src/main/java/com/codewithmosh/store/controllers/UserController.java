package com.codewithmosh.store.controllers;

import com.codewithmosh.store.entities.User;
import com.codewithmosh.store.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/* carlpeters created on 02/05/2025 inside the package - com.codewithmosh.store.controllers */
@AllArgsConstructor
@RestController
public class UserController {

    private final UserRepository userRepository;

//    public UserController(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }

    @GetMapping("/users")
    public Iterable<User> getAllUsers() {
        // This is a mock implementation. In a real application, you would fetch users from the database.
//        return List.of(
//                new User("Carl", "Peters"),
//                new User("John", "Doe"),
//                new User("Jane", "Smith")
//        );

        return userRepository.findAll();
    }
}
