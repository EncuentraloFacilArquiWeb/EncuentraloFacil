package com.com.jwtdemo.service;

import com.com.jwtdemo.DTO.SellerDTO;
import com.com.jwtdemo.model.Pais;
import com.com.jwtdemo.model.Seller;
import com.com.jwtdemo.repository.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SellerService {

    private final SellerRepository sellerRepository;

    @Autowired
    public SellerService(SellerRepository sellerRepository) {
        this.sellerRepository = sellerRepository;
    }

    public Seller addSeller(Seller seller) {
        return sellerRepository.save(seller);
    }
    public List<Seller> lista() {
        return sellerRepository.findAll();
    }

}
