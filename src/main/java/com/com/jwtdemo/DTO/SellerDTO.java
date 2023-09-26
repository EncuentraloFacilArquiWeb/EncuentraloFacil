package com.com.jwtdemo.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SellerDTO {

    private Integer id;
    private String name;
    private Integer store;
    private String storeDescription;
    private String storeLocation;

    // Constructor, getters y setters
}
