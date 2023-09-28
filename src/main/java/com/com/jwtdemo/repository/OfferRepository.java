package com.com.jwtdemo.repository;

import com.com.jwtdemo.model.Offer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OfferRepository extends JpaRepository <Offer, Long>{
}
