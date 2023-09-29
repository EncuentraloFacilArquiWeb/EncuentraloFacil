package com.com.jwtdemo.controller;

import com.com.jwtdemo.DTO.ProductDTO;
import com.com.jwtdemo.DTO.SellerDTO;
import com.com.jwtdemo.model.*;
import com.com.jwtdemo.service.AuthService;
import com.com.jwtdemo.service.PaisService;
import com.com.jwtdemo.service.ProductService;
import com.com.jwtdemo.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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

    /*@GetMapping("/auth/api/product/list")
    public ResponseEntity<List<Product>> list () {
        return new ResponseEntity<>(productService.lista(), HttpStatus.OK);
    }*/

    @DeleteMapping("/auth/product/{id}")
    public ResponseEntity<Product> elimina(@PathVariable Long id) throws Exception { return new ResponseEntity<>(productService .elimina(id), HttpStatus.OK); }

    @GetMapping("/product/list")
    @PreAuthorize("hasRole('USER')") // Ajusta según tus necesidades de seguridad
    public ResponseEntity<List<ProductDTO>> getAllProduct() {
        List<ProductDTO> product = productService.getAllProduct();
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

}