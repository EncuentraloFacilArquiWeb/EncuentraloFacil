package com.com.jwtdemo.controller;

import com.com.jwtdemo.model.*;
import com.com.jwtdemo.service.AuthService;
import com.com.jwtdemo.service.PaisService;
import com.com.jwtdemo.service.ProductService;
import com.com.jwtdemo.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class ProductController {
    //@Autowired
    private final AuthService authService;
    //@Autowired
    private final ProductService productService;


    public ProductController(AuthService authService, ProductService productService) {
        this.authService = authService;
        this.productService = productService;
    }


    @PostMapping("/auth/api/product")
    public ResponseEntity<Product> inserta (@RequestBody Product product) {
        return new ResponseEntity<>(productService.addProduct(product), HttpStatus.CREATED);
    }

    @GetMapping("/auth/api/product")
    public ResponseEntity<List<Product>> lista () {
        return new ResponseEntity<>(productService.lista(), HttpStatus.OK);
    }






}