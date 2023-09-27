package com.com.jwtdemo.controller;

import com.com.jwtdemo.model.*;
import com.com.jwtdemo.service.AuthService;
import com.com.jwtdemo.service.ConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class ConsumerController {
    //@Autowired
    private final AuthService authService;
    //@Autowired
    private final ConsumerService consumerService;


    public ConsumerController(AuthService authService, ConsumerService consumerService) {
        this.authService = authService;
        this.consumerService = consumerService;
    }
    @PostMapping("/auth/api/consumer")
    public ResponseEntity<Consumer> inserta (@RequestBody Consumer consumer) {
        return new ResponseEntity<>(consumerService.addConsumer(consumer), HttpStatus.CREATED);
    }

    @GetMapping("/auth/api/consumer")
    public ResponseEntity<List<Consumer>> lista () {
        return new ResponseEntity<>(consumerService.lista(), HttpStatus.OK);
    }






}