package com.codewithmosh.store.dtos;

/* carlpeters created on 02/05/2025 inside the package - com.codewithmosh.store.dtos */
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class UserDto {
    private Long id;
    private String name;
    private String email;
}
