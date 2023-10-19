package com.com.EncuentraloFacil.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SellerDTO {

    private Long id;
    private String name;
    private Integer store;
    private String storeDescription;
    private String storeLocation;
    private UserDTO user;

    // Constructor, getters y setters
}
