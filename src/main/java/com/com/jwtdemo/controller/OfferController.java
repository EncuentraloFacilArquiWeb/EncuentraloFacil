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
public class OfferController {
    private final OfferService offerService;


    public OfferController(OfferService offerService) {
        this.offerService = offerService;
    }


    @PostMapping("/auth/api/offer")
    public ResponseEntity<Offer> inserta (@RequestBody Offer offer) {
        return new ResponseEntity<>(offerService.addOffer(offer), HttpStatus.CREATED);
    }

    @GetMapping("/auth/api/offer")
    public ResponseEntity<List<Offer>> lista () {
        return new ResponseEntity<>(offerService.lista(), HttpStatus.OK);
    }

}
