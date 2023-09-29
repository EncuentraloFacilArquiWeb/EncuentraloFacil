package com.com.jwtdemo.service;

import com.com.jwtdemo.model.Product;
import com.com.jwtdemo.model.Seller;
import com.com.jwtdemo.repository.ProductRepository;
import org.springdoc.api.OpenApiResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product addProduct(Product product) {
        return productRepository.save(product);
    }
    public List<Product> lista() {
        return productRepository.findAll();
    }

    public Product elimina (Long id) throws Exception {
        // Pregunta si existe
        Product pro = productRepository.findById(id)
                .orElseThrow(() -> new OpenApiResourceNotFoundException("Id de producto no existe: "+ id));

        productRepository.delete(pro);
        return pro;
    }

}