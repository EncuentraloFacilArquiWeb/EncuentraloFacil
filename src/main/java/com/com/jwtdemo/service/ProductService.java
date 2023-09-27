package com.com.jwtdemo.service;

import com.com.jwtdemo.model.Product;
import com.com.jwtdemo.model.Seller;
import com.com.jwtdemo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductService productService;
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository, ProductService productService) {
        this.productService = productService;
        this.productRepository = productRepository;
    }

    public Product addProduct(Product product) {
        return productRepository.save(product);
    }
    public List<Product> lista() {
        return productRepository.findAll();
    }

}