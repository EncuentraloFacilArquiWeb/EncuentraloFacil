package com.com.EncuentraloFacil.controller;

import com.com.EncuentraloFacil.model.*;
import com.com.EncuentraloFacil.service.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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
