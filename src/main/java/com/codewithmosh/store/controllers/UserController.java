package com.codewithmosh.store.controllers;

import com.codewithmosh.store.entities.User;
import com.codewithmosh.store.repositories.UserRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/* carlpeters created on 02/05/2025 inside the package - com.codewithmosh.store.controllers */
@AllArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {

    private final UserRepository userRepository;

//    public UserController(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }

    @GetMapping("")
    public Iterable<User> getAllUsers() {
        // This is a mock implementation. In a real application, you would fetch users from the database.
//        return List.of(
//                new User("Carl", "Peters"),
//                new User("John", "Doe"),
//                new User("Jane", "Smith")
//        );

        return userRepository.findAll();
    }

    @GetMapping("/count")
    public Long getUserCount() {
        return userRepository.count();
    }
    @GetMapping("/first")
    public User getFirstUser() {
        return userRepository.findAll().iterator().next();
    }
    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return userRepository.findById(id).orElse(null);
    }
}
