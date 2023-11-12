package com.com.jwtdemo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double price;
    private String category;
    private String brand;
    private Date expiration_date;


    @ManyToOne (fetch = FetchType.LAZY)//Muchos productos son de un vendedor
    @JsonIgnoreProperties( {"hibernateLazyInitializar", "handler"})
    private Seller seller;

}