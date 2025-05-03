package com.codewithmosh.store.controllers;

import com.codewithmosh.store.dtos.UserDto;
import com.codewithmosh.store.entities.User;
import com.codewithmosh.store.mappers.UserMapper;
import com.codewithmosh.store.repositories.UserRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

import static org.hibernate.Hibernate.map;

/* carlpeters created on 02/05/2025 inside the package - com.codewithmosh.store.controllers */
@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @GetMapping("")
    public List<UserDto> getAllUsers(@RequestParam(required = false, defaultValue = "", name = "sort") String sortBy) {
        log.debug("Getting all users");

        if ( ! Set.of("name", "email", "createdAt").contains(sortBy) )
            sortBy = "name";

        return userRepository.findAll(Sort.by(sortBy))
                .stream()
                .map(userMapper ::userToUserDto)
                .toList();
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
    public ResponseEntity<UserDto> getUserById(@PathVariable Long id) {
        var user = userRepository.findById(id).orElse(null);
        log.debug("User: {}", user);
        if (user == null) {
            return  ResponseEntity.notFound().build();
        }
        return  ResponseEntity.ok(userMapper.userToUserDto(user));
    }
}
