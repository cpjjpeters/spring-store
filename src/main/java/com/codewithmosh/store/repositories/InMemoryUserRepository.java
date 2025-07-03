package com.codewithmosh.store.repositories;

import com.codewithmosh.store.entities.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

/* carlpeters created on 03/07/2025 inside the package - com.codewithmosh.store.repositories */
@Repository
public class InMemoryUserRepository  implements UserRepository {

    private final Map<String,User> users = new HashMap<>();

    @Override
    public void save(User user) {
        System.out.println("Saving user: " + user.getName() + " with email: " + user.getEmail());
        users.put(user.getEmail(), user);
    }

    @Override
    public User findByEmail(String email) {
        return users.getOrDefault(email, null);
    }
}
