package com.com.jwtdemo.controller;

import com.com.jwtdemo.DTO.SellerDTO;
import com.com.jwtdemo.model.*;
import com.com.jwtdemo.service.AuthService;
import com.com.jwtdemo.service.SellerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class SellerController {
    private final AuthService authService;
    private final SellerService sellerService;


    public SellerController(AuthService authService, SellerService sellerService) {
        this.authService = authService;
        this.sellerService = sellerService;
    }

    @PostMapping("/auth/api/seller")
    public ResponseEntity<Seller> inserta (@RequestBody Seller seller) {
        return new ResponseEntity<>(sellerService.addSeller(seller), HttpStatus.CREATED);
    }

    @GetMapping("/auth/api/seller/list")//PUEDEN SER LA MISMA RUTA PORQUE UNO ES POST Y EL OTRO ES GET
    public ResponseEntity<List<Seller>> lista() {
        return new ResponseEntity<>(sellerService.lista(), HttpStatus.OK);
    }

    @DeleteMapping("seller/delete/{id}")
    public ResponseEntity<Seller> delete(@PathVariable Long id) throws Exception { return new ResponseEntity<>(sellerService.delete(id), HttpStatus.OK); }

    @GetMapping("seller/list")
    public ResponseEntity<List<SellerDTO>> getAllSellers() {
        List<SellerDTO> sellers = sellerService.getAllSellers();
        return new ResponseEntity<>(sellers, HttpStatus.OK);
    }


}