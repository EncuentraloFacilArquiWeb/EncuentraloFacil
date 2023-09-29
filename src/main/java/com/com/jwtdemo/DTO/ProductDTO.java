package com.com.jwtdemo.DTO;

import com.com.jwtdemo.model.Product;
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


    public static ProductDTO fromProduct(Product product) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(product.getId());
        productDTO.setPrice(product.getPrice());
        productDTO.setBrand(product.getBrand());
        productDTO.setCategory(product.getCategory());

        // Otros campos que puedas tener en ProductDTO

        return productDTO;
    }
    public static ProductDTO convertToDTO(Product product) {
        return fromProduct(product);
    }

}
