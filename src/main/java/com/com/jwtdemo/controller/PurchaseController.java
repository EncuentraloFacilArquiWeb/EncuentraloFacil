package com.com.jwtdemo.controller;

import com.com.jwtdemo.model.*;
import com.com.jwtdemo.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin()
@RestController
@RequestMapping
public class PurchaseController {
    //@Autowired
    private final PurchaseService purchaseService;


    public PurchaseController(PurchaseService purchaseService) {
        this.purchaseService = purchaseService;
    }


    @PostMapping("/auth/api/purchase")
    public ResponseEntity<Purchase> inserta (@RequestBody Purchase purchase) {
        return new ResponseEntity<>(purchaseService.addPurchase(purchase), HttpStatus.CREATED);
    }

    @GetMapping("/auth/api/purchase")
    public ResponseEntity<List<Purchase>> lista () {
        return new ResponseEntity<>(purchaseService.lista(), HttpStatus.OK);
    }

}
