package com.com.jwtdemo.controller;

import com.com.jwtdemo.model.*;
import com.com.jwtdemo.service.AuthService;
import com.com.jwtdemo.service.PaisService;
import com.com.jwtdemo.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class SellerController {
    //@Autowired
    private final AuthService authService;
    //@Autowired
    private final SellerService sellerService;


    public SellerController(AuthService authService, PaisService paisService, SellerService sellerService) {
        this.authService = authService;
        this.sellerService = sellerService;
    }

    // Generan un token
    //@PostMapping("/auth/login")
    //public ResponseEntity<AuthResponse> login (@RequestBody LoginRequest request) {
    //    return ResponseEntity.ok(authService.login(request));
    //}

    //@PostMapping("/auth/register")
   // public ResponseEntity<AuthResponse> register (@RequestBody RegisterRequest request) {
   //     return ResponseEntity.ok(authService.register(request));

   // }
    // Endpoints que requieren autenticación (Token)
   // @GetMapping("/auth/api/v1/show")
    //public ResponseEntity<String> showDemo () {
    //    return new ResponseEntity<>("Bienvenido desde un endpoint seguro", HttpStatus.OK);
    //}

    @PostMapping("/auth/api/seller")
    public ResponseEntity<Seller> inserta (@RequestBody Seller seller) {
        return new ResponseEntity<>(sellerService.addSeller(seller), HttpStatus.CREATED);
    }

    @GetMapping("/auth/api/seller/list")//PUEDEN SER LA MISMA RUTA PORQUE UNO ES POST Y EL OTRO ES GET
    public ResponseEntity<List<Seller>> lista() {
        return new ResponseEntity<>(sellerService.lista(), HttpStatus.OK);
    }






}