package com.com.EncuentraloFacil.controller;

import com.com.EncuentraloFacil.DTO.ProductDTO;
import com.com.EncuentraloFacil.model.Product;
import com.com.EncuentraloFacil.service.AuthService;
import com.com.EncuentraloFacil.service.ProductService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@CrossOrigin()
@RestController
@RequestMapping("api/product")
public class ProductController {
    //@Autowired
    private final AuthService authService;
    //@Autowired
    private final ProductService productService;


    public ProductController(AuthService authService, ProductService productService) {
        this.authService = authService;
        this.productService = productService;
    }


    //@PostMapping("/auth/api/product")
    //public ResponseEntity<Product> inserta (@RequestBody Product product) {
    //    return new ResponseEntity<>(productService.addProduct(product), HttpStatus.CREATED);
    //}
    ///@CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/addProduct")
    public ResponseEntity<Product> inserta (@RequestBody Product product) {
        return new ResponseEntity<>(productService.addProduct(product), HttpStatus.CREATED);
    }

    /*@GetMapping("/auth/api/product/list")
    public ResponseEntity<List<Product>> list () {
        return new ResponseEntity<>(productService.lista(), HttpStatus.OK);
    }*/
    //@CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Product> elimina(@PathVariable Long id) throws Exception {
        return new ResponseEntity<>(productService .elimina(id), HttpStatus.OK); }


   //@CrossOrigin(origins = "http://localhost:4200")
    @GetMapping()
    public ResponseEntity<List<ProductDTO>> getAllProduct() {
        List<ProductDTO> product = productService.getAllProduct();
        return new ResponseEntity<>(product, HttpStatus.OK);
    }
    /*//@CrossOrigin(origins = "http://localhost:4200")
    @GetMapping()
    public List<ProductDTO> getAllProduct() {
        return productService.getAllProduct();
    }*/

    //@CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/byCategory")
    public ResponseEntity<List<ProductDTO>> getProductsByCategory(@RequestParam String category) {
        List<ProductDTO> products = productService.getProductsByCategory(category);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

}