package com.com.EncuentraloFacil.DTO;

import com.com.EncuentraloFacil.model.Role;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    //Integer id;
    //String username;
    String lastname;
    String firstname;
    String country;
    //String password;
    @Enumerated(EnumType.STRING)
    Role role;


}
