package com.com.EncuentraloFacil.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequest {// esto puede ser un DTO
    String username;
    String password;
    String firstname;
    String lastname;
    String country;
}
