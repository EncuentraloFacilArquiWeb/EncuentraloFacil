package com.com.EncuentraloFacil.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Purchase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer quantity;
    private Date emission_date= new Date();
    private double amount;


    @ManyToOne (fetch = FetchType.LAZY)
    @JsonIgnoreProperties( {"hibernateLazyInitializar", "handler"})
    private Consumer consumer;

    @ManyToOne (fetch = FetchType.LAZY)
    @JsonIgnoreProperties( {"hibernateLazyInitializar", "handler"})
    private Product product;

}
