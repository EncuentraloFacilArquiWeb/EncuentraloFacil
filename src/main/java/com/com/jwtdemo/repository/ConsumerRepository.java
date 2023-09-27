package com.com.jwtdemo.repository;

import com.com.jwtdemo.model.Consumer;
import com.com.jwtdemo.model.Seller;
import com.com.jwtdemo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ConsumerRepository extends JpaRepository<Consumer, Long>{


}
