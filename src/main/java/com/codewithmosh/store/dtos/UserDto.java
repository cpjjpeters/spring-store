package com.codewithmosh.store.dtos;

/* carlpeters created on 02/05/2025 inside the package - com.codewithmosh.store.dtos */
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
 @NoArgsConstructor

public class UserDto {
    private Long id;
    private String name;
    private String email;
}
