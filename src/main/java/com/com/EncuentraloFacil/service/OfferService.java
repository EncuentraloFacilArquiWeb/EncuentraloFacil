package com.com.EncuentraloFacil.service;

import com.com.EncuentraloFacil.model.Offer;

import com.com.EncuentraloFacil.repository.OfferRepository;
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
