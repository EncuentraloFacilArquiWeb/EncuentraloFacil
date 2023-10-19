package com.com.EncuentraloFacil.service;

import com.com.EncuentraloFacil.model.Purchase;

import com.com.EncuentraloFacil.repository.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
