package com.com.jwtdemo.service;

import com.com.jwtdemo.model.Offer;

import com.com.jwtdemo.model.Purchase;
import com.com.jwtdemo.repository.OfferRepository;
import com.com.jwtdemo.repository.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OfferService {
    private final OfferRepository offerRepository;
    @Autowired
    public OfferService(OfferRepository offerRepository){this.offerRepository= offerRepository;}

    public Offer addOffer(Offer offer){return offerRepository.save(offer);}
    public List<Offer> lista() {
        return offerRepository.findAll();
    }

}
