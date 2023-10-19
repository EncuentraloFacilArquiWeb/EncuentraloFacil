package com.com.EncuentraloFacil.repository;

import com.com.EncuentraloFacil.model.Offer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OfferRepository extends JpaRepository <Offer, Long>{
}
