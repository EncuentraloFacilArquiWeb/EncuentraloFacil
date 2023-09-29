package com.com.jwtdemo.DTO;

import com.com.jwtdemo.model.User;
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
    private User user;

    // Constructor, getters y setters
}
