package com.com.jwtdemo.service;

import com.com.jwtdemo.model.Purchase;

import com.com.jwtdemo.repository.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.PublicKey;
import java.util.List;

@Service
public class PurchaseService {
    private final PurchaseRepository purchaseRepository;
    @Autowired
    public  PurchaseService(PurchaseRepository purchaseRepository){this.purchaseRepository= purchaseRepository;}

    public Purchase addPurchase(Purchase purchase){return purchaseRepository.save(purchase);}
    public List<Purchase> lista() {
        return purchaseRepository.findAll();
    }
}
