package com.codewithmosh.store.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/* carlpeters created on 03/07/2025 inside the package - com.codewithmosh.store.entities */
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class User {
    private Long id;
    private String name;
    private String email;
    private String password;
}
