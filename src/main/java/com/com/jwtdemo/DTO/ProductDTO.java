package com.com.jwtdemo.DTO;

import com.com.jwtdemo.model.Seller;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
    private Long id;
    private double price;
    private String category;
    private String brand;
    private Date expiration_date;

    private SellerDTO seller;
}
